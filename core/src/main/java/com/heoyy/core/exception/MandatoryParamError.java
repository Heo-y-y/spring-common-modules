package com.heoyy.core.exception;

import com.heoyy.core.response.ResultCode;

/**
 * 420
 */
public class MandatoryParamError extends BaseException {
    public MandatoryParamError() {
        super(ResultCode.RC420);
    }

    public MandatoryParamError(String msg) {
        super(ResultCode.RC420, msg);
    }
}
