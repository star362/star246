package com.auth.sunia.star247.logs.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author star362
 * @Date 2023/7/7 17:17
 * @Description: TODO
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface LogCat {

    String bid() default "";

    boolean print() default true;
}
