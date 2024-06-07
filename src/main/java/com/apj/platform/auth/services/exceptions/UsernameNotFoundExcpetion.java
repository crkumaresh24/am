package com.apj.platform.auth.services.exceptions;

import com.apj.platform.auth.constants.ErrorCodes;
import com.apj.platform.auth.vo.SystemException;

public class UsernameNotFoundExcpetion extends SystemException {

    public UsernameNotFoundExcpetion(String username) {
        super(username);
        addToParams(username);
    }

    @Override
    public String getErrorcode() {
        return ErrorCodes.ERR_USERNAME_NOTFOUND;
    }
}
