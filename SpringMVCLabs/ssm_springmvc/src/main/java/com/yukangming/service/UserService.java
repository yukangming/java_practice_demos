package com.yukangming.service;

import com.yukangming.entity.User;

import java.util.List;

public interface UserService {
    public void save(User user);

    public List<User> findAll();
}
