package com.heoyy.core.exception;

import com.heoyy.core.response.ResultCode;

public class RequestTimeout extends BaseException {
    public RequestTimeout() {
        super(ResultCode.RC408);
    }

    public RequestTimeout(String msg) {
        super(ResultCode.RC408, msg);
    }
}
