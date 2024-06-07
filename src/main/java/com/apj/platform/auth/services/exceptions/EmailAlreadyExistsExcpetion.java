package com.apj.platform.auth.services.exceptions;

import com.apj.platform.auth.constants.ErrorCodes;
import com.apj.platform.auth.vo.SystemException;

public class EmailAlreadyExistsExcpetion extends SystemException {

    public EmailAlreadyExistsExcpetion(String email) {
        super(email);
        addToParams(email);
    }

    @Override
    public String getErrorcode() {
        return ErrorCodes.ERR_EMAIL_EXISTS;
    }
}
