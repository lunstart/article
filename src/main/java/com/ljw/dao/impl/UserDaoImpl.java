package com.ljw.dao.impl;

import com.ljw.bean.User;
import com.ljw.dao.UserDao;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    /**
     * @param username 用户名
     * @return
     */
    @Override
    public User queryUserByUsername(String username) {
        //language=MySQL
        String sql = "select * from `users` where  username = ?";
//        String sql = "select `id`,`username`,`password`,`email`,`right`,`time` " +
//                "from `users` where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndpassword(String username, String password) {
        //language=MySQL
        String sql = "select * from `users` where username = ? and password = ?";
//        String sql = "select `id`,`username`,`password`,`email`,`right`,`time` " +
//                "from `users` where username = ? and password = ?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public User queryUsernameById(Integer id) {
        //language=MySQL
        String sql = "select * from users where `id` = ?";
        return queryForOne(User.class,sql,id);
    }

    @Override
    public int saveUser(User user) {
        //language=MySQL
        String sql = "insert into `users` (`username`,`password`) values(?,?)";
        return update(sql, user.getUsername(), user.getPassword());
    }

    @Override
    public int updateUser(User user) {
        //language=MySQL
        String sql = "update `users` set `username`=?,`password`=?,`email`=? where id = ?";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getId());
    }

    @Override
    public int updateUserRight(User user) {
        //language=MySQL
        String sql = "update `users` set `right`=? where id = ?";

        return update(sql,user.getRight(),user.getId());
    }


    @Override
    public List<User> queryAll() {
        //language=MySQL
        String sql = "select * from users";
        return queryForList(User.class,sql);
    }

    @Override
    public List<User> querySearch(String str) {
        //language=MySQL
        String sql = "select * from users where username like ?";
        String str1 = "%" +str +"%";
        return queryForList(User.class,sql,str1);
    }

}
