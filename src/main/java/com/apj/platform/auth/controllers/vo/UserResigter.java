package com.apj.platform.auth.controllers.vo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.apj.platform.commons.constants.AuthErrorCodes;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserResigter {
    @NotBlank(message = AuthErrorCodes.ERR_USERNAME_BLANK)
    private String username;
    @NotBlank(message = AuthErrorCodes.ERR_PASSWORD_BLANK)
    @Size(min = 8, max = 16, message = AuthErrorCodes.ERR_PASSWORD_LENGTH)
    private String password;
    @NotBlank(message = AuthErrorCodes.ERR_FULLNAME_BLANK)
    private String fullName;
    @Pattern(regexp = "male | female | other", message = AuthErrorCodes.ERR_GENDER_INVALID)
    private String gender;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = AuthErrorCodes.ERR_DOB_FUTURE)
    private LocalDate dob;
    @Email(message = AuthErrorCodes.ERR_EMAIL_INVALID)
    private String email;
    @NotBlank(message = AuthErrorCodes.ERR_MOBILE_BLANK)
    @Pattern(regexp = "\\d+", message = AuthErrorCodes.ERR_MOBILE_INVALID)
    @Size(min = 10, max = 10, message = AuthErrorCodes.ERR_MOBILE_INVALID)
    private String mobileNo;
}
