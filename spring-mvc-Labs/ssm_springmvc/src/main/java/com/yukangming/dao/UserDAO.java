package com.yukangming.dao;

import com.yukangming.entity.User;

import java.util.List;

public interface UserDAO {

    public void save(User user);

    List<User> findAll();
}
