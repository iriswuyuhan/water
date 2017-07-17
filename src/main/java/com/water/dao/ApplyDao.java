package com.water.dao;

import com.water.model.ApplyEntity;

import java.util.Date;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
public interface ApplyDao {
    /**
     *
     */
    public ApplyEntity sendApplication(String idApply, Double longitude, Double latitude, String number, String address, Integer postcode, Date applyDate, Integer state, byte[] image);

    /**
     *
     */
    public int updateState(Integer state);

    /**
     *
     */
    public ApplyEntity addApplication();

    /**
     *
     */
    public ApplyEntity searchApplication(String idApply);
}
