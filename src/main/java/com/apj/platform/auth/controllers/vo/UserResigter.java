package com.apj.platform.auth.controllers.vo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.apj.platform.auth.constants.ErrorCodes;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserResigter {
    @NotBlank(message = ErrorCodes.ERR_USERNAME_BLANK)
    private String username;
    @NotBlank(message = ErrorCodes.ERR_PASSWORD_BLANK)
    @Size(min = 8, max = 16, message = ErrorCodes.ERR_PASSWORD_LENGTH)
    private String password;
    @NotBlank(message = ErrorCodes.ERR_FULLNAME_BLANK)
    private String fullName;
    @Pattern(regexp = "male | female | other", message = ErrorCodes.ERR_GENDER_INVALID)
    private String gender;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = ErrorCodes.ERR_DOB_FUTURE)
    private LocalDate dob;
    @Email(message = ErrorCodes.ERR_EMAIL_INVALID)
    private String email;
    @NotBlank(message = ErrorCodes.ERR_MOBILE_BLANK)
    @Pattern(regexp = "\\d+", message = ErrorCodes.ERR_MOBILE_INVALID)
    @Size(min = 10, max = 10, message = ErrorCodes.ERR_MOBILE_INVALID)
    private String mobileNo;
}
