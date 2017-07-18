package com.water.service.Impl;

import com.water.model.ApplyEntity;
import com.water.service.ApplyService;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
public class ApplyServiceImpl implements ApplyService{
    /**
     *
     */
    public ApplyEntity sendApplication(String idApply, Double longitude, Double latitude, String number, String address, Integer postcode, Date applyDate, Integer state, byte[] image){return null;}

    /**
     *
     */
    public int updateState(Integer state){return 0;}

    /**
     *
     */
    public ApplyEntity addApplication(){return null;}

    /**
     *
     */
    public ApplyEntity searchApplication(String idApply){return null;}

    public ArrayList<ApplyEntity> getApplicationList(String state) {
        return null;
    }
}
