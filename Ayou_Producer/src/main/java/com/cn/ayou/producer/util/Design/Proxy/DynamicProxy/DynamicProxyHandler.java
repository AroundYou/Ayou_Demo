package com.cn.ayou.producer.util.Design.Proxy.DynamicProxy;

import com.alibaba.druid.support.spring.stat.SpringStatUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName DynamicProxyHandler
 * @Deseiption 动态
 * @Author AYOU
 * @Date 2019/7/26 18:08
 * @Version 1.0
 **/
public class DynamicProxyHandler implements InvocationHandler {

    private  Object object;

    public DynamicProxyHandler(final Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("买房前准备");
        Object result = method.invoke(object, args);
        System.out.println("买房后装修");
        return result;
    }
}
