package com.heoyy.test.config;

import com.heoyy.core.exception.BaseException;
import com.heoyy.core.response.ApiResponse;
import com.heoyy.core.response.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 실제 프로젝트에서는 Service 모듈의 Config 에서 설정
 * TODO : core 모듈은 순수 유틸 모듈이기 때문에 GlobalExceptionHandler 를 해당 테스트 모듈에 설정함
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 비즈니스 로직에서 던진 예외
     */
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiResponse<Void>> handleBusinessException(BaseException e) {
        log.warn("[BusinessException] {}", e.getMessage());
        return ResponseEntity
                .status(e.getCode().getCode())
                .body(ApiResponse.failure(e.getCode().getCode(), e.getMessage()));
    }

    /**
     * 시스템 에러 등 처리되지 않은 예외
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleUnexpected(Exception e) {
        log.error("[UnhandledException]", e);
        return ResponseEntity
                .status(ResultCode.RC500.getCode())
                .body(ApiResponse.failure(
                        ResultCode.RC500.getCode(),
                        "알 수 없는 서버 오류가 발생했습니다."
                ));
    }
}
