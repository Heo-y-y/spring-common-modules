package com.heoyy.core.exception;

import com.heoyy.core.response.ResultCode;

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
