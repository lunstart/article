package com.ljw.dao;

import com.ljw.bean.Article;
import com.ljw.bean.Follow;

import java.util.List;

public interface FollowDao {
    /**
     * 增加关注
     * @param follow
     * @return
     */
    public int addFollow(Follow follow);

    /**
     * 通过两个ID删除关注
     * @param follow
     * @return
     */
    public int deleteFollowById(Follow follow);

    /**
     * 通过两个ID查询
     * @param userId
     * @param followId
     * @return null为未关注
     */
    public Follow queryFollowById(Integer userId,Integer followId);


    /**
     * 遍历集合
     * @return
     */
    public List<Follow> queryFollow(Integer id);
}
