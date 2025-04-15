package com.heoyy.core.exception;

import com.heoyy.core.response.ResultCode;

/**
 * 400
 */
public class BadRequest extends BaseException {
    public BadRequest() {
        super(ResultCode.RC400);
    }

    public BadRequest(String msg) {
        super(ResultCode.RC400, msg);
    }
}
