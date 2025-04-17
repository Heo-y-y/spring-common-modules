package com.heoyy.exception;

import com.heoyy.enums.ResultCode;

/**
 * 434
 */
public class RemovalFailed extends BaseException {
    public RemovalFailed() {
        super(ResultCode.RC434);
    }

    public RemovalFailed(String msg) {
        super(ResultCode.RC434, msg);
    }
}

