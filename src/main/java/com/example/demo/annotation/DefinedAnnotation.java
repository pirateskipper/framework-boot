package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @author blindskipper
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DefinedAnnotation {
    String value() default "";
    int sort();
}
