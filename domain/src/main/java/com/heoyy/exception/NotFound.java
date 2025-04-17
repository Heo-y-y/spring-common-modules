package com.heoyy.exception;

import com.heoyy.enums.ResultCode;

/**
 * 404
 */
public class NotFound extends BaseException {
    public NotFound() {
        super(ResultCode.RC404);
    }

    public NotFound(String entityName) {
        super(ResultCode.RC404, entityName + " 을(를) 찾을 수 없습니다.");
    }
}

