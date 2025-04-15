package com.heoyy.core.exception;

import com.heoyy.core.response.ResultCode;

/**
 * 430
 */
public class QueryFailed extends BaseException {
    public QueryFailed() {
        super(ResultCode.RC430);
    }

    public QueryFailed(String msg) {
        super(ResultCode.RC430, msg);
    }
}
