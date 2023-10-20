package com.java.auth.log.annotation;

import com.java.auth.log.TraceIdConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hy
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(TraceIdConfiguration.class)
public @interface EnableTraceId {

    boolean clearTraceIdOnExit() default false;
}
