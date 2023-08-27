package com.ljw.dao;

import com.ljw.bean.Collect;

import java.util.List;

public interface CollectDao {
    /**
     * @param collect
     * @return
     */
    public int addCollect(Collect collect);

    /**
     * @param
     * @return
     */
    public int deleteCollect(Collect collect);

    /**
     * @param id
     * @return
     */
    public List<Collect> queryCollectById(Integer id);

    /**
     * 查询是否收藏
     * @param collect
     * @return
     */
    public Collect queryCollectById(Collect collect);

    /**
     *
     * @param id
     * @return
     */
    public int deleteById(Integer id);

}
