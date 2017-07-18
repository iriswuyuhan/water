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
     * @param idApply
     * @param name
     * @param longitude
     * @param latitude
     * @param number
     * @param address
     * @param postcode
     * @param applyDate
     * @param state
     * @param image
     */
    public void sendApplication(String idApply, String name, Double longitude, Double latitude, String number, String address, Integer postcode, Date applyDate, Integer state, byte[] image);

    /**
     *
     * @param idApply
     * @param state
     */
    public void updateState(String idApply, Integer state);

    /**
     *
     * @param idApply
     * @return
     */
    public ArrayList<ApplyEntity> searchApplicationById(String idApply);

    /**
     *
     * @param state
     * @return
     */
    public ArrayList<ApplyEntity> searchApplicationByState(Integer state);
}
