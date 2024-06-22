package com.apj.platform.auth.services.exceptions;

import com.apj.platform.auth.constants.AuthErrorCodes;
import com.apj.platform.commons.vo.SystemException;

public class UsernameAlreadyExistsExcpetion extends SystemException {

    public UsernameAlreadyExistsExcpetion(String username) {
        super(username);
        addToParams(username);
    }

    @Override
    public String getErrorcode() {
        return AuthErrorCodes.ERR_USERNAME_EXISTS;
    }
}
