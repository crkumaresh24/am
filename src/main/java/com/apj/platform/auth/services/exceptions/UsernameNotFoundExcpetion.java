package com.apj.platform.auth.services.exceptions;

import com.apj.platform.commons.constants.AuthErrorCodes;
import com.apj.platform.commons.vo.SystemException;

public class UsernameNotFoundExcpetion extends SystemException {

    public UsernameNotFoundExcpetion(String username) {
        super(username);
        addToParams(username);
    }

    @Override
    public String getErrorcode() {
        return AuthErrorCodes.ERR_USERNAME_NOTFOUND;
    }
}
