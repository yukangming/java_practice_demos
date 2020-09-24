package com.yukangming.proxy;

import com.yukangming.basic.User;
import com.yukangming.basic.UserService;

public class UserServiceProxy implements UserService {
    private UserServiceImpl userServiceImpl = new UserServiceImpl();
    @Override
    public void register(User user) {
        System.out.println("-------log-------");
        userServiceImpl.register(user);
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("--------log--------");
        return userServiceImpl.login(name, password);
    }
}
