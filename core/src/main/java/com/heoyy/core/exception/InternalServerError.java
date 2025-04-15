package com.heoyy.core.exception;

import com.heoyy.core.response.ResultCode;

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
