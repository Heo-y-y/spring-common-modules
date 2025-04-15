package com.heoyy.test.rest;

import com.heoyy.core.response.ApiResponse;
import com.heoyy.core.response.ResultCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${controller.base-url}/response")
public class ResponseTestController {

    /**
     * 기본 성공 응답 테스트
     */
    @GetMapping("/success")
    public ApiResponse<String> testSuccess() {
        return ApiResponse.success("정상 응답입니다.");
    }

    /**
     * 커스터마이징 실패 응답 테스트
     */
    @GetMapping("/fail-custom")
    public ApiResponse<Void> testCustomFail() {
        return ApiResponse.failure(400, "입력값이 잘못되었습니다.");
    }

    /**
     * ResultCode enum 기반 실패 응답 테스트
     */
    @GetMapping("/fail-enum")
    public ApiResponse<Void> testEnumFail() {
        return ApiResponse.failure(ResultCode.RC401);
    }

    /**
     * 실패 응답 + payload 포함 테스트
     */
    @GetMapping("/fail-with-payload")
    public ApiResponse<String> testFailWithPayload() {
        return ApiResponse.failure(409, "중복된 요청입니다.", "이미 존재하는 항목입니다.");
    }
}
