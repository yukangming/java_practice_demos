package com.yukangming.aspect;

import com.yukangming.basic.User;
import com.yukangming.basic.UserDao;

public class UserServiceImpl implements UserService {
    @Override
    public void register(User user) {
        System.out.println("my register method");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("my login method");
        return true;
    }
}
