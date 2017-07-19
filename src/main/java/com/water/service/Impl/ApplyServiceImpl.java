package com.water.service.Impl;

import com.water.dao.ApplyDao;
import com.water.dao.UserDao;
import com.water.entity.Apply;
import com.water.entity.User;
import com.water.model.ApplyEntity;
import com.water.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
@Service
public class ApplyServiceImpl implements ApplyService{
    @Autowired
    private ApplyDao applyDao;
    public void addApply(){
        Apply apply = new Apply();
        apply.setIdApply(Long.valueOf(548946));
        apply.setAddress("NJU4546578");
        apply.setImage("kshfioakdfjojsofsf");
        apply.setLatitude(5.154);
        apply.setLongitude(9.545);
        apply.setName("李四");
        apply.setNumber("11111111111");
        apply.setState(0);
        applyDao.save(apply);
    }

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
