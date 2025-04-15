package com.heoyy.core.exception;

import com.heoyy.core.response.ResultCode;

/**
 * 433
 */
public class ModificationFailed extends BaseException {
    public ModificationFailed() {
        super(ResultCode.RC433);
    }

    public ModificationFailed(String msg) {
        super(ResultCode.RC433, msg);
    }
}
