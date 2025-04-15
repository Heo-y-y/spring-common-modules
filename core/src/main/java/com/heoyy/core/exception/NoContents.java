package com.heoyy.core.exception;

import com.heoyy.core.response.ResultCode;

/**
 * 201
 */
public class NoContents extends BaseException {
    public NoContents() {
        super(ResultCode.RC201);
    }

    public NoContents(String msg) {
        super(ResultCode.RC201, msg);
    }
}
