package com.heoyy.exception;

import com.heoyy.enums.ResultCode;

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

