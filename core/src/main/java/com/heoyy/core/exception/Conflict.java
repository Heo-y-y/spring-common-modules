package com.heoyy.core.exception;

import com.heoyy.core.response.ResultCode;

/**
 * 409
 */
public class Conflict extends BaseException {
    public Conflict() {
        super(ResultCode.RC409);
    }

    public Conflict(String msg) {
        super(ResultCode.RC409, msg);
    }
}
