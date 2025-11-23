package com.yukangming.factory;

import com.yukangming.basic.User;

public interface UserService {
    public void login(String name, String password);

    public boolean register(User user);
}
