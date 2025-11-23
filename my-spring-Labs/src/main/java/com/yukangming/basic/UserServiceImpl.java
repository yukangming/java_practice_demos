package com.yukangming.basic;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register(User user) {
        userDao.save(user);
    }

    @Override
    public boolean login(String name, String password) {
        userDao.queryUserByNameAndPassword(name, password);
        return true;
    }
}
