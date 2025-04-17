package com.heoyy.exception;

import com.heoyy.enums.ResultCode;

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

