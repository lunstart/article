package com.ljw.service.impl;

import com.ljw.bean.Collect;
import com.ljw.dao.CollectDao;
import com.ljw.dao.impl.BaseDao;
import com.ljw.dao.impl.CollectDaoImpl;
import com.ljw.service.CollectService;

import java.util.List;

public class CollectServiceImpl extends BaseDao implements CollectService {
    private CollectDao collectDao = new CollectDaoImpl();

    @Override
    public void addCollect(Collect collect) {
        collectDao.addCollect(collect);
    }

    @Override
    public void deleteCollect(Collect collect) {
        collectDao.deleteCollect(collect);
    }



    @Override
    public List<Collect> queryAllById(Integer id) {
        return collectDao.queryCollectById(id);
    }

    @Override
    public boolean isCollect(Collect collect) {
        if (collectDao.queryCollectById(new Collect(null, collect.getUser_id(), collect.getArticle_id())) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void deleteById(Integer id) {
        collectDao.deleteById(id);
    }
}
