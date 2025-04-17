package com.heoyy.exception;

import com.heoyy.enums.ResultCode;

public class RequestTimeout extends BaseException {
    public RequestTimeout() {
        super(ResultCode.RC408);
    }

    public RequestTimeout(String msg) {
        super(ResultCode.RC408, msg);
    }
}

