package com.apj.platform.auth.services.exceptions;

import com.apj.platform.commons.constants.AuthErrorCodes;
import com.apj.platform.commons.vo.SystemException;

public class EmailNotFoundExcpetion extends SystemException {

    public EmailNotFoundExcpetion(String email) {
        super(email);
        addToParams(email);
    }

    @Override
    public String getErrorcode() {
        return AuthErrorCodes.ERR_EMAIL_NOTFOUND;
    }
}
