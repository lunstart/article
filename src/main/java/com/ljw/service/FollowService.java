package com.ljw.service;

import com.ljw.bean.Follow;

import java.util.List;

public interface FollowService {
    /**
     *
     * @param follow
     */
    public void addFollow(Follow follow);

    /**
     *
     * @param
     * @return
     */
    public boolean isFollow(Integer UserId,Integer FollowId);

    /**
     *
     * @param follow
     */
    public void deleteFollow(Follow follow);

    /**
     *
     * @return
     */
    public List<Follow> queryFollow(Integer id);
}
