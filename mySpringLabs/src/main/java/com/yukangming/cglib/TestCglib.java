package com.yukangming.cglib;


import com.yukangming.basic.User;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestCglib extends UserService{
    public static void main(String[] args) {
        UserService userService = new UserService();

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(TestCglib.class.getClassLoader());
        enhancer.setSuperclass(userService.getClass());
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("the extra function before the original method ");
                Object ret = method.invoke(userService, objects);
                return ret;
            }
        };
        enhancer.setCallback(methodInterceptor);
        UserService userServiceProxy = (UserService) enhancer.create();
        userServiceProxy.login("Kangming Yu", "99999");
        userServiceProxy.register(new User());
    }
}
