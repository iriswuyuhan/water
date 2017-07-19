package com.water.service;

import com.water.entity.Apply;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
public interface ApplyService {
    public void addApply();
    /**
     *
     */
    public Apply sendApplication(String idApply, Double longitude, Double latitude, String number, String address, Integer postcode, Date applyDate, Integer state, byte[] image);

    /**
     *
     */
    public boolean updateState(long id,Integer state);

    /**
     *
     */
    public Apply addApplication();

    /**
     *
     */
    public Apply searchApplication(long idApply);

    public ArrayList<Apply> getApplicationList(int state);
}
