package com.ljw.dao.impl;


import com.ljw.bean.Collect;
import com.ljw.dao.CollectDao;

import java.util.List;

public class CollectDaoImpl extends BaseDao implements CollectDao {


    @Override
    public int addCollect(Collect collect) {
        //language=MySQL
        String sql = "insert into collect ( `user_id`, `article_id`) values (?,?)";
        return update(sql, collect.getUser_id(), collect.getArticle_id());
    }

    @Override
    public int deleteCollect(Collect collect) {
        //language=MySQL
        String sql = "delete from collect where user_id =? and article_id =?";
        return update(sql,collect.getUser_id(),collect.getArticle_id());
    }



    @Override
    public List<Collect> queryCollectById(Integer id) {
        //language=MySQL
        String sql = "select * from collect where user_id = ?";
        return queryForList(Collect.class,sql,id);
    }

    @Override
    public Collect queryCollectById(Collect collect) {
        //language=MySQL
        String sql = "select * from collect where user_id = ? and article_id = ?";
        return queryForOne(Collect.class,sql,collect.getUser_id(),collect.getArticle_id());
    }

    @Override
    public int deleteById(Integer id) {
        //language=MySQL
        String sql = "delete  from collect where article_id = ?";
        return update(sql,id);
    }
}
