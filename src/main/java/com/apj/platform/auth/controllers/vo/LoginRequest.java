package com.apj.platform.auth.controllers.vo;

import com.apj.platform.commons.constants.AuthErrorCodes;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "strategy", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = LoginRequest.UsernameLoginRequest.class, name = "USERNAME_PASSWORD"),
        @JsonSubTypes.Type(value = LoginRequest.EmailLoginRequest.class, name = "EMAIL_PASSWORD"),
        @JsonSubTypes.Type(value = LoginRequest.EmailOTPLoginRequest.class, name = "EMAIL_OTP"),
        @JsonSubTypes.Type(value = LoginRequest.MobileOTPLoginRequest.class, name = "MOBILENO_OTP")
})
public class LoginRequest {
    public String strategy;

    public static class UsernameLoginRequest extends LoginRequest {

        @NotBlank(message = AuthErrorCodes.ERR_USERNAME_BLANK)
        String username;
        @NotBlank(message = AuthErrorCodes.ERR_PASSWORD_BLANK)
        String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }

    public static class EmailLoginRequest extends LoginRequest {

        @Email(message = AuthErrorCodes.ERR_EMAIL_INVALID)
        String username;
        @NotBlank(message = AuthErrorCodes.ERR_PASSWORD_BLANK)
        String password;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String email) {
            this.username = email;
        }

    }

    public static class EmailOTPLoginRequest extends LoginRequest {

        @Email(message = AuthErrorCodes.ERR_EMAIL_INVALID)
        String email;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    }

    public static class MobileOTPLoginRequest extends LoginRequest {

        @NotBlank(message = AuthErrorCodes.ERR_MOBILE_BLANK)
        @Pattern(regexp = "\\d+", message = AuthErrorCodes.ERR_MOBILE_INVALID)
        @Size(min = 10, max = 10, message = AuthErrorCodes.ERR_MOBILE_INVALID)
        String mobileno;

        public String getMobileno() {
            return mobileno;
        }

        public void setMobileno(String mobileno) {
            this.mobileno = mobileno;
        }

    }
}
