package com.java.auth.log;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



import static com.java.auth.log.TraceIDUtil.DEFAULT_TRACE_ID;


/**
 * @author hy
 */
public class TraceIdInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String traceId = request.getHeader(DEFAULT_TRACE_ID);
        if (traceId == null) {
            traceId = TraceIDUtil.getTraceId();
        }
        TraceIDUtil.setTraceIdToMdcAndTtl(traceId);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView) {
        TraceIDUtil.clearTraceId();
    }
}
