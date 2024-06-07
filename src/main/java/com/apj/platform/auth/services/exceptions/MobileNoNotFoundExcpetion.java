package com.apj.platform.auth.services.exceptions;

import com.apj.platform.auth.constants.ErrorCodes;
import com.apj.platform.auth.vo.SystemException;

public class MobileNoNotFoundExcpetion extends SystemException {

    public MobileNoNotFoundExcpetion(String mobileno) {
        super(mobileno);
        addToParams(mobileno);
    }

    @Override
    public String getErrorcode() {
        return ErrorCodes.ERR_MOBILENO_NOTFOUND;
    }
}
