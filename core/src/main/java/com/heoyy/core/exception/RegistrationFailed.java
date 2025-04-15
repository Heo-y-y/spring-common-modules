package com.heoyy.core.exception;

import com.heoyy.core.response.ResultCode;

/**
 * 431
 */
public class RegistrationFailed extends BaseException {
    public RegistrationFailed() {
        super(ResultCode.RC431);
    }

    public RegistrationFailed(String msg) {
        super(ResultCode.RC431, msg);
    }
}

