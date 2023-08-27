package com.ljw.service;

import com.ljw.bean.User;

import java.util.List;

public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    public User Login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return true表示存在，false表示不存在
     */
    public boolean existsUsername(String username);

    /**
     * 修改信息
     * @param user
     */
    public void alertUser(User user);

    /**
     * 修改权限
     * @param user
     */
    public void alterUserRight(User user);

    /**
     * 查询用户ID
     * @param username
     * @return
     */
    public int queryIdByUsername(String username);

    /**
     * 查询用户名
     * @param id
     * @return
     */
    public String queryUsernameById(Integer id);

    /**
     * 查询用户信息
     * @param id
     * @return
     */
    public  User queryUserById(Integer id);

    public List<User> queryAll();

    public List<User> querySearch(String str);
}
