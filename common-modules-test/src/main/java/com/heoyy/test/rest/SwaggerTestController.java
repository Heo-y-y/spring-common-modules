package com.heoyy.test.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${controller.base-url}/swagger")
public class SwaggerTestController {

    @GetMapping("/hello")
    public String hello() {
        return "공통 모듈 테스트 앱입니다!";
    }
}
