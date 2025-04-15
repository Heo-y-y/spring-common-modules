package com.heoyy.core.exception;

import com.heoyy.core.response.ResultCode;

/**
 * 422
 */
public class MandatoryHeaderError extends BaseException {
    public MandatoryHeaderError() {
        super(ResultCode.RC422);
    }

    public MandatoryHeaderError(String msg) {
        super(ResultCode.RC422, msg);
    }
}
