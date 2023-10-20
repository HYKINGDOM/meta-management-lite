package com.java.auth.log;

import cn.hutool.core.util.StrUtil;
import com.java.auth.log.annotation.EnableTraceId;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author hy
 */
@Slf4j
@Aspect
@Component
@Order(1)
public class TraceIdAspect {

    @Around("@annotation(enableTraceId)")
    public Object around(ProceedingJoinPoint joinPoint, EnableTraceId enableTraceId) throws Throwable {
        String traceId = TraceIDUtil.getTraceId();
        if (StrUtil.isEmpty(traceId)) {
            traceId = TraceIDUtil.getTraceId();
            TraceIDUtil.setTraceIdToMdcAndTtl(traceId);
        }
        try {
            return joinPoint.proceed();
        } finally {
            if (enableTraceId.clearTraceIdOnExit()) {
                TraceIDUtil.clearTraceId();
            }
        }
    }
}
