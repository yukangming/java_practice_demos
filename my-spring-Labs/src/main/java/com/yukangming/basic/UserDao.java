package com.yukangming.basic;

public interface UserDao {
    public void save(User user);

    public void queryUserByNameAndPassword(String name, String password);
}
