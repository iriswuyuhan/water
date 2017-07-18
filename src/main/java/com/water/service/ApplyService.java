package com.water.service;

import com.water.model.ApplyEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
public interface ApplyService {
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

    public ArrayList<ApplyEntity> getApplicationList(String state);
}
