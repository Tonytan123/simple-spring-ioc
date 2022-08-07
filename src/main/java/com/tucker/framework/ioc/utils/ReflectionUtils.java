package com.tucker.framework.ioc.utils;

import java.lang.reflect.Field;

/**
 * @author tucker
 */
public class ReflectionUtils {
    /**
     * use java's reflection principle to complete dependency injection of objects
     * */
    public static void injectField(Field field, Object obj, Object value) throws IllegalAccessException {
        if(field != null) {
            field.setAccessible(true);
            field.set(obj, value);
        }
    }
}
