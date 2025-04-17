package com.heoyy.exception;

import com.heoyy.enums.ResultCode;

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

