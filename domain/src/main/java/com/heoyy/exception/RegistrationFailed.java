package com.heoyy.exception;

import com.heoyy.enums.ResultCode;

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

