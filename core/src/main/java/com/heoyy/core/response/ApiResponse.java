package com.heoyy.core.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 공통 API 응답 래퍼 클래스
 */
@Data
@Builder
public class ApiResponse<T> {

    private Integer resultCode;       // 상태 코드 (예: 200, 400, 500)
    private String resultMsg;         // 응답 메시지 (성공/실패 안내 메시지)

    @Builder.Default
    private LocalDateTime when = LocalDateTime.now().withNano(0);  // 응답 시간

    private T payload;                // 응답 데이터

    /**
     * 성공 응답 생성
     */
    public static <T> ApiResponse<T> success(T payload) {
        return ApiResponse.<T>builder()
                .resultCode(ResultCode.RC200.getCode())
                .resultMsg(ResultCode.RC200.getUserMsg())
                .payload(payload)
                .build();
    }

    /**
     * 실패 응답 생성 (코드 + 메시지 + 데이터)
     */
    public static <T> ApiResponse<T> failure(int resultCode, String message, T payload) {
        return ApiResponse.<T>builder()
                .resultCode(resultCode)
                .resultMsg(message)
                .payload(payload)
                .build();
    }

    /**
     * 실패 응답 생성 (코드 + 메시지)
     */
    public static <T> ApiResponse<T> failure(int resultCode, String message) {
        return failure(resultCode, message, null);
    }

    /**
     * 실패 응답 생성 (ResultCode enum 사용)
     */
    public static <T> ApiResponse<T> failure(ResultCode code) {
        return failure(code.getCode(), code.getUserMsg(), null);
    }
}
