package com.tucker.framework.ioc.utils;

/**
 * @author tonyc
 * @since 2022-07-31
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class loadClass(String ClassName) {
        try{
            return getDefaultClassLoader().loadClass(ClassName);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
