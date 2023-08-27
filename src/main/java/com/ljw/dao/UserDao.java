package com.ljw.dao;

import com.ljw.bean.User;

import java.util.List;

public interface UserDao {

    /**
     * 根据用户名查询信息
     * @param username 用户名
     * @return
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    public User queryUserByUsernameAndpassword(String username,String password);

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    public User queryUsernameById(Integer id);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);

    /**
     * 修改信息
     * @param user
     * @return
     */
    public int updateUser(User user);

    public int updateUserRight(User user);

    public List<User> queryAll();

    public List<User> querySearch(String str);

}
