package com.heoyy.core.exception;

import com.heoyy.core.response.ResultCode;

/**
 * 432
 */
public class GenerationFailed extends BaseException {
    public GenerationFailed() {
        super(ResultCode.RC432);
    }

    public GenerationFailed(String msg) {
        super(ResultCode.RC432, msg);
    }
}
