package com.tucker.framework.ioc.utils;

import java.lang.reflect.Constructor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * @author tucker
 */
public class BeanUtils {
    /**
     * use cglib to generate proxy class
     * and instantiating objects
     * */
    public static <T> T instanceByCglib(Class<T> clz, Constructor ctr,Object[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clz);
        enhancer.setCallback(NoOp.INSTANCE);
        if(ctr == null){
            return (T) enhancer.create();
        } else {
            return (T) enhancer.create(ctr.getParameterTypes(), args);
        }
    }
}
