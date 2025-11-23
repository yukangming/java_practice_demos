package com.yukangming.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("this is the function added after bean processor");
                Object ret = method.invoke(bean, args);
                return ret;
            }
        };

        Object ret = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), bean.getClass().getInterfaces(), invocationHandler);
        return ret;
    }
}
