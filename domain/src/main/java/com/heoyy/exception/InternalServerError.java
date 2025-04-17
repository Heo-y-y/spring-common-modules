package com.heoyy.exception;

import com.heoyy.enums.ResultCode;

/**
 * 500
 */
public class InternalServerError extends BaseException {
    public InternalServerError() {
        super(ResultCode.RC500);
    }

    public InternalServerError(String msg) {
        super(ResultCode.RC500, msg);
    }
}

