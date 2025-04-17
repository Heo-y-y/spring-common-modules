package com.heoyy.exception;

import com.heoyy.enums.ResultCode;

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

