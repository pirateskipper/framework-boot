package com.example.demo.annotation;

import java.lang.annotation.Repeatable;

/**
 * @author blindskipper
 */
@Repeatable(Schedules.class)
public @interface Schedule {
    int sort() default 0;
}
