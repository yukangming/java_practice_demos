package com.yukangming.cglib;

import com.yukangming.basic.User;

public class UserService {
    public void login(String name, String password) {
        System.out.println("UserService.login");
    }

    public boolean register(User user) {
        System.out.println("UserService.register");
        return true;
    }
}
