package com.yukangming.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Arround implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("the extra function before the original method");
        Object ret = methodInvocation.proceed();
        System.out.println("the extra function after the original method");
        return ret;

    }
}
