package com.yukangming.aspect;

import com.yukangming.basic.User;

public interface UserService {
    public void register(User user);

    public boolean login(String name, String password);
}
