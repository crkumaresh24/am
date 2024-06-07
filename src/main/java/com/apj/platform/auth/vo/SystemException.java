package com.apj.platform.auth.vo;

import java.util.ArrayList;
import java.util.List;

public abstract class SystemException extends Exception {
    public List<Object> params;

    public abstract String getErrorcode();

    public void addToParams(Object value) {
        if (null == params) {
            params = new ArrayList<>();
        }
        params.add(value);
    }

    public SystemException(String message) {
        super(message);
    }

}
