package com.tucker.framework.ioc.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tucker.framework.ioc.bean.BeanDefinition;
import com.tucker.framework.ioc.utils.JsonUtils;

import java.io.InputStream;
import java.util.List;

/**
 * @author tonyc
 */
public class JsonApplicationContext extends BeanFactoryImpl{
    private String fileName;

    public JsonApplicationContext(String fileName) {
        this.fileName = fileName;
    }

    public void init() {
        loadFile();
    }

    private void loadFile() {
        InputStream is = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(this.fileName);
        List<BeanDefinition> beanDefinitions = JsonUtils
                .readValue(is, new TypeReference<List<BeanDefinition>>() {});

        if (beanDefinitions != null && !beanDefinitions.isEmpty()) {
            for (BeanDefinition beanDefinition : beanDefinitions) {
                registerBean(beanDefinition.getName(), beanDefinition);
            }
        }
    }
}
