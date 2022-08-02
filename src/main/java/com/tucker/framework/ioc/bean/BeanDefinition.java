package com.tucker.framework.ioc.bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Properties;

/**
 * @author tonyc
 *
 * ioc中的核心数据结构，用于描述IOC框架管理的对象
 *
 */
@Data
@ToString
public class BeanDefinition{
    private String name;
    private String className;
    private String interfaceName;
    /**
    * 构造函数的传参列表
     */
    private List<ConstructArg> constructArgList;
    /**
     * 需要注入的参数列表
     */
    private List<PropertyArg> propertyArgList;
}