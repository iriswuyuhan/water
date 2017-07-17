package com.water.dao;

import com.water.model.ApplyEntity;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
public interface ApplyDao {
    /**
     *
     */
    public ApplyEntity sendApplication();

    /**
     *
     */
    public int updateState();

    /**
     *
     */
    public ApplyEntity addApplication();

    /**
     *
     */
    public ApplyEntity searchApplication();
}
