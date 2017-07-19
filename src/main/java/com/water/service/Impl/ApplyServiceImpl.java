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

    //这个方法用来测试增加数据
    public void addApply(){
        Apply apply = new Apply();
        apply.setIdApply(Long.valueOf(1661166116));
        apply.setAddress("南京市栖霞区2333");
        apply.setImage("http:dsfadijj色调上i55523");
        apply.setLatitude(30.00);
        apply.setLongitude(105.22);
        apply.setApplyDate(new Date(System.currentTimeMillis()));
        apply.setName("Tati");
        apply.setNumber("77777777777");
        apply.setState(0);
        applyDao.save(apply);
    }

    /**
     * 删除apply 不存在返回false
     * @param id
     * @return
     */
    public boolean deleteApply(long id){
        if(applyDao.get(id)==null)
            return false;
        applyDao.delete(id);
        return true;
    }

    /**
     * 更改状态 申请号不存在返回false
     * @param id
     * @param state
     * @return
     */
    public boolean updateState(long id ,Integer state){
        Apply apply = applyDao.get(id);
        if(apply==null)
            return false;
        apply.setState(state);
        applyDao.saveOrUpdate(apply);
        return true;
    }

    /**
     * 根据申请号搜索apply
     * @param idApply
     * @return
     */
    public Apply searchApplication(long idApply){
        return applyDao.get(idApply);
    }

    /**
     * 根据状态返回apply列表
     * @param state
     * @return
     */
    public ArrayList<Apply> getApplicationList(int state) {
        List<Apply> arrayList = applyDao.findAll();
        ArrayList<Apply> list = new ArrayList<Apply>();
        for(Apply temp:arrayList){
            if(temp.getState()==state){
                list.add(temp);
            }
        }
        return  list;
    }

    public Apply sendApplication(String idApply, Double longitude, Double latitude, String number, String address, Integer postcode, Date applyDate, Integer state, byte[] image){return null;}

    public Apply addApplication(long idApply, Double longitude, Double latitude, String number, String address, Date applyDate, Integer state,String image, String name){return null;}
}
