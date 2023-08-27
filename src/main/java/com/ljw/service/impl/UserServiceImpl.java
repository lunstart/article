package com.ljw.service.impl;

import com.ljw.dao.impl.UserDaoImpl;
import com.ljw.dao.UserDao;
import com.ljw.bean.User;
import com.ljw.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User Login(User user) {
        return userDao.queryUserByUsernameAndpassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) return false;
        else {
            return true;
        }
    }

    @Override
    public void alertUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void alterUserRight(User user) {
       userDao.updateUserRight(new User(user.getId(),null,null,null,user.getRight(),null));
    }

    @Override
    public int queryIdByUsername(String username) {
        return userDao.queryUserByUsername(username).getId();
    }

    @Override
    public String queryUsernameById(Integer id) {
        return userDao.queryUsernameById(id).getUsername();
    }

    @Override
    public User queryUserById(Integer id) {
        return userDao.queryUsernameById(id);
    }

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    @Override
    public List<User> querySearch(String str) {
        return userDao.querySearch(str);
    }
}
