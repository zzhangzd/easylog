package com.maketubo.easylog.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

/**
 * 标记需要记录日志的方法
 * @mender maketubo
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogMethod {

    /**
     * 归属的模块
     */
    String module() default "default";

    /**
     * 日志格式
     */
    String log_format() default "[$OBJECT_ID][$FUNCTION_MODULE]| $LOG_TEXT | request from ip:$IP";

    Class clazz() default Map.class;
}
