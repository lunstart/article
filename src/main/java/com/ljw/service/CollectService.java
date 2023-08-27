package com.ljw.service;

import com.ljw.bean.Collect;

import java.util.List;

public interface CollectService {
    public void addCollect(Collect collect);

    public void deleteCollect(Collect collect);

    public List<Collect> queryAllById(Integer id);

    public boolean isCollect(Collect collect);

    public void deleteById(Integer id);

}
