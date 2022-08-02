package com.tucker.framework.ioc.core;

/**
 * @author tonyc
 */
public interface BeanFactory {
    /**
     * getBean
     * getBean by bean's name
     *
     * @param name String
     *
     * @return Object
     *
     * @throws Exception exception
     */
    Object getBean(String name) throws Exception;
}
