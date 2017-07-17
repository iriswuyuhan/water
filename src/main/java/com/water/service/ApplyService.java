package com.water.service;

import com.water.model.ApplyEntity;

import java.util.List;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
public interface ApplyService {
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
