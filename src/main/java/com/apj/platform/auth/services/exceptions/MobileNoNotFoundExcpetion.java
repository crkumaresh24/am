package com.apj.platform.auth.services.exceptions;

import com.apj.platform.commons.constants.AuthErrorCodes;
import com.apj.platform.commons.vo.SystemException;

public class MobileNoNotFoundExcpetion extends SystemException {

    public MobileNoNotFoundExcpetion(String mobileno) {
        super(mobileno);
        addToParams(mobileno);
    }

    @Override
    public String getErrorcode() {
        return AuthErrorCodes.ERR_MOBILENO_NOTFOUND;
    }
}
