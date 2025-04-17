package com.heoyy.boot.config;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    /**
     * REST API 요청에 대한 로깅 처리
     */
    @Around("execution(public * com.heoyy.rest..*(..))")
    public Object logApiRequest(final ProceedingJoinPoint joinPoint) throws Throwable {
        String line = "-".repeat(60);

        log.info("📌 [API 요청 시작] {} {}", joinPoint.getSignature().toShortString(), line);
        log.info("🕒 호출 시간     : {}", LocalDateTime.now());
        log.info("🔧 메서드       : {}", joinPoint.getSignature().toShortString());
        log.info("📦 파라미터     : {}", Arrays.toString(joinPoint.getArgs()));

        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attrs != null) {
            HttpServletRequest request = attrs.getRequest();
            log.info("🌐 URL         : {}", request.getRequestURL());
            log.info("📡 IP          : {}", request.getRemoteAddr());
            log.info("📬 Method      : {}", request.getMethod());

            if (request instanceof ContentCachingRequestWrapper wrapper) {
                String body = new String(wrapper.getContentAsByteArray(), request.getCharacterEncoding());
                log.info("📝 Body        : {}", body.isEmpty() ? request.getQueryString() : body);
            } else if (request.getQueryString() != null) {
                log.info("🔎 Params      : {}", request.getQueryString());
            }
        }

        log.info("{} {}", "📌 [요청 종료]", line);

        return joinPoint.proceed();
    }

    /**
     * 배치 작업(예: @Scheduled 메서드) 로깅 처리
     */
    @Around(
            "execution(* com.heoyy.job..*(..)) || " +
                    "execution(* com.heoyy.logic..*.*Batch*(..)) || " +
                    "execution(* com.heoyy.logic..*.batch*(..))"
    )
    public Object logBatchExecution(final ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        String line = "-".repeat(80);

        log.info("🛠️ [배치 시작] {} {}", methodName, line);
        log.info("📥 인자: {}", Arrays.toString(args));

        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long end = System.currentTimeMillis();

            log.info("📤 결과: {}", result);
            log.info("✅ [배치 완료] {} (⏱️ {}ms) {}", methodName, end - start, line);

            return result;
        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            log.error("❌ [배치 오류] {} (⏱️ {}ms) {}", methodName, end - start, line, e);
            throw e;
        }
    }
}
