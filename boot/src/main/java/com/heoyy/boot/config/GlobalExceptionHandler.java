package com.heoyy.boot.config;

import com.heoyy.enums.ResultCode;
import com.heoyy.exception.BaseException;
import com.heoyy.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 비즈니스 로직에서 던진 예외
     */
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiResponse<Void>> handleBusinessException(BaseException e) {
        log.warn("⚠️ 사용자 정의 예외 발생: {}", e.getMessage());
        return ResponseEntity
                .status(e.getCode().getCode())
                .body(ApiResponse.failure(e.getCode().getCode(), e.getMessage()));
    }

    /**
     * 시스템 에러 등 처리되지 않은 예외
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleUnexpected(Exception e) {
        log.error("⚠️ 서버 내부 오류", e);
        return ResponseEntity
                .status(ResultCode.RC500.getCode())
                .body(ApiResponse.failure(
                        ResultCode.RC500.getCode(),
                        "알 수 없는 서버 오류가 발생했습니다."
                ));
    }
}

