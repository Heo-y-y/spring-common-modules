package com.heoyy.test.rest;

import com.heoyy.core.exception.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${controller.base-url}/exception")
public class ExceptionTestController {

    @GetMapping("/not-found")
    public void throwNotFound() {
        throw new NotFound("테스트용 NotFound 예외 발생!");
    }

    @GetMapping("/bad-request")
    public void throwBadRequest() {
        throw new BadRequest("테스트용 BadRequest 예외 발생!");
    }

    @GetMapping("/timeout")
    public void throwTimeout() {
        throw new RequestTimeout("응답 지연 테스트 예외!");
    }

    @GetMapping("/internal")
    public void throwInternal() {
        throw new InternalServerError("테스트용 서버 오류 발생!");
    }
}
