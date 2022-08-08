package com.tucker.framework.ioc.core;

import com.tucker.framework.ioc.bean.BeanDefinition;
import com.tucker.framework.ioc.bean.ConstructArg;
import com.tucker.framework.ioc.utils.BeanUtils;
import com.tucker.framework.ioc.utils.ClassUtils;
import java.lang.reflect.Constructor;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

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

    private Object createBean(BeanDefinition beanDefinition) throws Exception {
        String beanName = beanDefinition.getClassName();
        Class bean = ClassUtils.loadClass(beanName);
        if(bean == null){
            throw new Exception("we cannot find bean by bean's class name");
        }
        List<ConstructArg> constructArgList = beanDefinition.getConstructArgList();
        if(constructArgList != null && !constructArgList.isEmpty()){
            List<Object> objectList = new ArrayList<>();
            constructArgList.stream().map( o -> {
                if(o.getValue() != null){
                    objectList.add(o.getValue());
                }else {
                    objectList.add(getBean(o.getName()));
                }
                return ;
            });
            Class[] constructOrArgTypes = objectList.stream().map(o -> o.getClass())
                    .collect(Collectors.toList()).toArray(new Class[]{});
            Constructor constructor = bean.getConstructor(constructOrArgTypes);
            return BeanUtils.instanceByCglib(bean, constructor, objectList.toArray());
        } else {
            return BeanUtils.instanceByCglib(bean, null, null);
        }
    }
}
