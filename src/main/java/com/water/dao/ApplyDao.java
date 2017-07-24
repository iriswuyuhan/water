package com.water.dao;

import com.water.entity.Apply;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
public interface ApplyDao extends  DaoUtil<Apply,Long>{
    public List<Apply> findApplyById(String idUser);
}
