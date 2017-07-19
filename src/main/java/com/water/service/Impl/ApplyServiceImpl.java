package com.water.service.Impl;

import com.water.dao.ApplyDao;
import com.water.dao.UserDao;
import com.water.entity.Apply;
import com.water.entity.User;
import com.water.entity.Apply;
import com.water.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
@Service
public class ApplyServiceImpl implements ApplyService{
    @Autowired
    private ApplyDao applyDao;
    public void addApply(){
        Apply apply = new Apply();
        apply.setIdApply(Long.valueOf(46464646));
        apply.setAddress("08885Over");
        apply.setImage("http:dsfadijji55523");
        apply.setLatitude(30.00);
        apply.setLongitude(105.22);
        apply.setApplyDate(new Date(System.currentTimeMillis()));
        apply.setName("Jefree");
        apply.setNumber("55555555555");
        apply.setState(0);
        applyDao.save(apply);
    }

    /**
     *
     */
    public Apply sendApplication(String idApply, Double longitude, Double latitude, String number, String address, Integer postcode, Date applyDate, Integer state, byte[] image){return null;}

    /**
     *
     */
    public boolean updateState(long id ,Integer state){
        Apply apply = applyDao.get(id);
        if(apply.equals(null))
            return false;
        apply.setState(state);
        applyDao.saveOrUpdate(apply);
        return true;
    }

    /**
     *
     */
    public Apply addApplication(){return null;}

    /**
     *
     */
    public Apply searchApplication(long idApply){
        return applyDao.get(idApply);}

    public ArrayList<Apply> getApplicationList(int state) {
       List<Apply> arrayList = applyDao.findAll();
        System.out.println(arrayList+"@@@@@@");
       ArrayList<Apply> list = new ArrayList<Apply>();
       for(Apply temp:arrayList){
          if(temp.getState()==state){
              list.add(temp);
          }
       }
       System.out.println(arrayList+"@@@@@@");
       return  list;

    }
}
