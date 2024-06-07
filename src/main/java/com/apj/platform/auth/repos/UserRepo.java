package com.apj.platform.auth.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apj.platform.auth.entities.User;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    boolean existsByEmail(String email);

    boolean existsByMobileNo(String mobileno);

    Optional<User> findByEmail(String email);

    Optional<User> findByMobileNo(String mobileno);
}
