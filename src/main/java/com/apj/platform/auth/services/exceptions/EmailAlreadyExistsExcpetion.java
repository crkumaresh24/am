package com.apj.platform.auth.services.exceptions;

import com.apj.platform.auth.constants.AuthErrorCodes;
import com.apj.platform.commons.vo.SystemException;

public class EmailAlreadyExistsExcpetion extends SystemException {

    public EmailAlreadyExistsExcpetion(String email) {
        super(email);
        addToParams(email);
    }

    @Override
    public String getErrorcode() {
        return AuthErrorCodes.ERR_EMAIL_EXISTS;
    }
}
