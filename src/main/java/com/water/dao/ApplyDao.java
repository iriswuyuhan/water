package com.water.dao;

import com.water.model.ApplyEntity;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
public interface ApplyDao {
    /**
     *
     */
    public void sendApplication(String idApply, String name, Double longitude, Double latitude, String number, String address, Integer postcode, Date applyDate, Integer state, byte[] image);

    /**
     *
     */
    public void updateState(String idApply, Integer state);

    /**
     *
     */
    public ArrayList<ApplyEntity> searchApplicationById(String idApply);

    /**
     *
     */
    public ArrayList<ApplyEntity> searchApplicationByState(Integer state);
}
