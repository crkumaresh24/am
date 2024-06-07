package com.apj.platform.auth.constants;

public interface ErrorCodes {
    String ERR_INPUT_VALIDATION = "exception.input.validation";
    String ERR_USERNAME_BLANK = "exception.input.username.blank";
    String ERR_PASSWORD_BLANK = "exception.input.password.blank";
    String ERR_PASSWORD_LENGTH = "exception.input.password.length";
    String ERR_FULLNAME_BLANK = "exception.input.fullname.blank";
    String ERR_GENDER_INVALID = "exception.input.gender.invalid";
    String ERR_DOB_INVALID = "exception.input.dob.invalid";
    String ERR_DOB_FUTURE = "exception.input.dob.future";
    String ERR_EMAIL_INVALID = "exception.input.email.invalid";
    String ERR_MOBILE_BLANK = "exception.input.mobileno.blank";
    String ERR_MOBILE_INVALID = "exception.input.mobileno.invalid";

    String ERR_BAD_CREDENTIALS = "exception.input.credentials.invalid";

    String ERR_USERNAME_EXISTS = "exception.username.exists";
    String ERR_USERNAME_NOTFOUND = "exception.username.notfound";
    String ERR_EMAIL_EXISTS = "exception.email.exists";
    String ERR_EMAIL_NOTFOUND = "exception.email.notfound";
    String ERR_MOBILENO_EXISTS = "exception.mobileno.exists";
    String ERR_MOBILENO_NOTFOUND = "exception.mobileno.notfound";
}
