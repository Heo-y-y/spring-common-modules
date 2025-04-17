package com.heoyy.exception;

import com.heoyy.enums.ResultCode;
import lombok.Getter;

/**
 * 커스텀 Exception
 */
@Getter
public abstract class BaseException extends RuntimeException {

    private final ResultCode code;
    private final String message;

    protected BaseException(ResultCode code) {
        super(code.getUserMsg());
        this.code = code;
        this.message = code.getUserMsg();
    }

    protected BaseException(ResultCode code, String customMessage) {
        super(customMessage);
        this.code = code;
        this.message = customMessage;
    }
}

