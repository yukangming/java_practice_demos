package com.yukangming.jdk;

import com.yukangming.basic.UserService;
import com.yukangming.proxy.UserServiceImpl;
import com.yukangming.proxy.UserServiceProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJDKProxy {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("the extra function before the original method");
                Object ret = method.invoke(userService, args);
                return ret;
            }
        };

        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(), userService.getClass().getInterfaces(), handler);
        userServiceProxy.login("KANGKANG", "12479");
    }
}
