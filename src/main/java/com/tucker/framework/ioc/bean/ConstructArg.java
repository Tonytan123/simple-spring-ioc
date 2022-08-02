package com.tucker.framework.ioc.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @author tonyc
 * 构造函数的传参列表
 */
@Data
@ToString
public class ConstructArg {
    private int index;
    private String ref;
    private String name;
    private Object value;
}
