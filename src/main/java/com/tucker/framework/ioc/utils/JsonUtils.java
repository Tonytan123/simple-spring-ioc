package com.tucker.framework.ioc.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tucker.framework.ioc.bean.BeanDefinition;

import java.io.InputStream;

/**
 * @author tucker
 */
public class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    private JsonUtils() {}

    public static ObjectMapper getObjectMapper()  {
        return mapper;
    }

    public static <T> T readValue(String json, Class<T> cls) {
        try {
            return mapper.readValue(json, cls);
        } catch(Exception e) {
            return null;
        }
    }

    public static <T> T readValue(InputStream is,Class<T> cls) {
        try {
            return mapper.readValue(is,cls);
        } catch(Exception e){
            return null;
        }
    }

    public static <T> T readValue(byte[] bytes, Class<T> cls) {
        try{
            return mapper.readValue(bytes, cls);
        } catch(Exception e) {
            return null;
        }
    }

    public static <T> T readValue(String json, TypeReference valueTypeRef){
        try {
            return (T) mapper.readValue(json, valueTypeRef);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T readValue(byte[] bytes, TypeReference valueTypeRef){
        try {
            return (T) mapper.readValue(bytes, valueTypeRef);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T readValue(InputStream is, TypeReference valueTypeRef){
        try {
            return (T) mapper.readValue(is, valueTypeRef);
        } catch (Exception e) {
            return null;
        }
    }

    public static String writeValue(Object entity) {
        try{
            return mapper.writeValueAsString(entity);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static byte[] writeByteValue(Object entity) {
        try {
            return mapper.writeValueAsBytes(entity);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    private Object createBean(BeanDefinition beanDefinition) throws Exception{
        String beanName = beanDefinition.getClassName();
        Class bean = ClassUtils.loadClass(beanName);
        if(bean == null) {
            throw new Exception("System cannot find bean by class name.");
        }

    }
}
