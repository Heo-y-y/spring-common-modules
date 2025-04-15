package com.heoyy.core.exception;

import com.heoyy.core.response.ResultCode;

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
