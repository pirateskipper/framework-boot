package com.example.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author blindskipper
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Schedules {
    Schedule[] value();
}
