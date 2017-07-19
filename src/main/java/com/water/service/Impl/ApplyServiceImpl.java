package com.water.service.Impl;

import com.water.dao.ApplyDao;
import com.water.entity.Apply;
import com.water.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
