package com.tucker.framework.ioc.core;

import com.tucker.framework.ioc.bean.BeanDefinition;

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

    @Override
    public Object getBean(String name) throws Exception {
        return null;
    }
}
