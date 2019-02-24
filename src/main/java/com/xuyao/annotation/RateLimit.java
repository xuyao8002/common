package com.xuyao.annotation;

import java.lang.annotation.*;

@Inherited
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimit {
    double permitsPerSecond() default 5.0;

    String key() default "";
}
