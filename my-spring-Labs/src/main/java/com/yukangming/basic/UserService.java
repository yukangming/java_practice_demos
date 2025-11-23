package com.yukangming.basic;

public interface UserService {
    public void register(User user);

    public boolean login(String name, String password);
}
