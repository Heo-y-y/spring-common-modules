package com.heoyy.exception;

import com.heoyy.enums.ResultCode;

/**
 * 421
 */
public class InvalidParamError extends BaseException {
    public InvalidParamError() {
        super(ResultCode.RC421);
    }

    public InvalidParamError(String msg) {
        super(ResultCode.RC421, msg);
    }
}

