package com.ljw.service.impl;

import com.ljw.bean.Follow;
import com.ljw.dao.FollowDao;
import com.ljw.dao.impl.BaseDao;
import com.ljw.dao.impl.FollowDaoImpl;
import com.ljw.service.FollowService;

import java.util.List;

public class FollowServiceImpl extends BaseDao implements FollowService {

    private FollowDao followDao = new FollowDaoImpl();

    @Override
    public void addFollow(Follow follow) {
        followDao.addFollow(follow);
    }

    @Override
    public boolean isFollow(Integer UserId, Integer FollowId) {
        if (followDao.queryFollowById(UserId, FollowId) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void deleteFollow(Follow follow) {
        followDao.deleteFollowById(follow);
    }

    @Override
    public List<Follow> queryFollow(Integer id) {
        return followDao.queryFollow(id);
    }
}
