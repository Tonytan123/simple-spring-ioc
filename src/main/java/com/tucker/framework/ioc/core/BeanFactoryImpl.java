package com.tucker.framework.ioc.core;

import com.tucker.framework.ioc.bean.BeanDefinition;
import com.tucker.framework.ioc.utils.ClassUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tucker
 */
public class BeanFactoryImpl implements BeanFactory{

    private static final ConcurrentHashMap<String, Object> beanMap = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private static final Set<String> beanNameSet = Collections.synchronizedSet(new HashSet<>());
    /**
     * @param name String
     * @return Object
     * @throws Exception
     */
    @Override
    public Object getBean(String name) throws Exception {
        return null;
    }

    private Object createBean(BeanDefinition beanDefinition) throws Exception{
        String beanName = beanDefinition.getClassName();
        Class bean = ClassUtils.loadClass(beanName);
        if(bean == null) {
            throw new Exception("System cannot find bean by class name.");
        }

    }
}
