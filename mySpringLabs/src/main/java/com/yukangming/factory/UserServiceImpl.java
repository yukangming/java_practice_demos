package com.yukangming.factory;

import com.yukangming.basic.User;

public class UserServiceImpl implements UserService {
    @Override
    public void login(String name, String password) {
        System.out.println("factory package UserService.login");
    }

    @Override
    public boolean register(User user) {
        System.out.println("factory package UserService.register");
        return true;
    }
}
