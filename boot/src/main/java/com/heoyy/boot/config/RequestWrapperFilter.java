package com.heoyy.boot.config;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.ContentCachingRequestWrapper;

/**
 * POST Body 로깅용 필터
 */
@Configuration
public class RequestWrapperFilter {

    @Bean
    public FilterRegistrationBean<Filter> contentCachingFilter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter((request, response, chain) -> {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(httpRequest);
            chain.doFilter(wrappedRequest, response);
        });
        registrationBean.setOrder(1); // 필터 우선순위
        return registrationBean;
    }
}
