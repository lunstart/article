package com.ljw.dao.impl;

import com.ljw.bean.Follow;
import com.ljw.dao.FollowDao;

import java.util.List;

public class FollowDaoImpl extends BaseDao implements FollowDao {
    @Override
    public int addFollow(Follow follow) {
        //language=MySQL
        String sql = "insert into `follow` ( `user_id`, `follow_user_id`) values(?,?)";
        return update(sql,follow.getUser_id(),follow.getFollow_user_id());
    }

    @Override
    public int deleteFollowById(Follow follow) {
        //language=MySQL
        String sql = "delete from `follow` where user_id = ? and follow_user_id = ?";
        return update(sql,follow.getUser_id(),follow.getFollow_user_id());
    }

    @Override
    public Follow queryFollowById(Integer userId, Integer followId) {
        //language=MySQL
        String sql = "select * from `follow` where user_id = ? and follow_user_id = ?";
        return queryForOne(Follow.class,sql,userId,followId);
    }


    @Override
    public List<Follow> queryFollow(Integer id) {
        //language=MySQL
        String sql = "select * from `follow` where `user_id` = ?";
        return queryForList(Follow.class,sql,id);
    }
}
