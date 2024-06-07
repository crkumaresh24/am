package com.apj.platform.auth.services.exceptions;

import com.apj.platform.auth.constants.ErrorCodes;
import com.apj.platform.auth.vo.SystemException;

public class EmailNotFoundExcpetion extends SystemException {

    public EmailNotFoundExcpetion(String email) {
        super(email);
        addToParams(email);
    }

    @Override
    public String getErrorcode() {
        return ErrorCodes.ERR_EMAIL_NOTFOUND;
    }
}
