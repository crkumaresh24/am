package com.apj.platform.auth.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.apj.platform.auth.controllers.vo.UserResigter;
import com.apj.platform.auth.entities.User;
import com.apj.platform.auth.repos.UserRepo;
import com.apj.platform.auth.services.exceptions.EmailAlreadyExistsExcpetion;
import com.apj.platform.auth.services.exceptions.EmailNotFoundExcpetion;
import com.apj.platform.auth.services.exceptions.MobileNoAlreadyExistsExcpetion;
import com.apj.platform.auth.services.exceptions.UsernameAlreadyExistsExcpetion;
import com.apj.platform.auth.services.exceptions.UsernameNotFoundExcpetion;
import com.apj.platform.commons.vo.SystemException;

@Service
public class AuthService {

    private final UserRepo userRepo;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepo userRepo, PasswordEncoder passwordEncoder,
            JwtService jwtService,
            AuthenticationManager authenticationManager) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public String signup(UserResigter userResigter) throws SystemException {

        if (isUsernameExists(userResigter.getUsername())) {
            throw new UsernameAlreadyExistsExcpetion(userResigter.getUsername());
        }

        if (isEmailExists(userResigter.getEmail())) {
            throw new EmailAlreadyExistsExcpetion(userResigter.getEmail());
        }

        if (isMobileExists(userResigter.getMobileNo())) {
            throw new MobileNoAlreadyExistsExcpetion(userResigter.getMobileNo());
        }

        User user = User.builder().username(userResigter.getUsername())
                .password(passwordEncoder.encode(userResigter.getPassword()))
                .enabled(true).mobileNo(userResigter.getMobileNo()).email(userResigter.getEmail()).build();

        return this.userRepo.save(user).getUsername();
    }

    public String loginByUsernamePassword(String username, String password) throws UsernameNotFoundExcpetion {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password));
        User user = this.userRepo.findById(username).orElseThrow(() -> new UsernameNotFoundExcpetion(username));
        return getToken(user);
    }

    public String loginByEmailPassword(String email, String password) throws EmailNotFoundExcpetion {
        User user = this.userRepo.findByEmail(email).orElseThrow(() -> new EmailNotFoundExcpetion(email));
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        password));
        return getToken(user);
    }

    public void loginByEmailOTP(String email) {

    }

    public void loginByMobileOTP(String mobileno) {

    }

    public boolean isUsernameExists(String username) {
        return this.userRepo.existsById(username);
    }

    public boolean isEmailExists(String username) {
        return this.userRepo.existsByEmail(username);
    }

    public boolean isMobileExists(String username) {
        return this.userRepo.existsByMobileNo(username);
    }

    private String getToken(User user) {
        return jwtService.generateToken(user);
    }
}
