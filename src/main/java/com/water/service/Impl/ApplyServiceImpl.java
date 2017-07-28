package com.water.service.Impl;

import com.water.dao.ApplyDao;
import com.water.dao.UploadDao;
import com.water.dao.UserDao;
import com.water.entity.Apply;
import com.water.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private ApplyDao applyDao;

    @Autowired
    private UploadDao uploadDao;

    @Autowired
    private UserDao userDao;

    //这个方法用来测试增加数据
    public void addApply() {
        Apply apply = new Apply();
        apply.setIdApply(Long.valueOf(55555555));
        apply.setAddress("南京市鼓楼区");
        List<String> list = new ArrayList<String>();
        list.add("adfdsa");
        apply.setImage(list);
        apply.setLatitude(28.55);
        apply.setLongitude(120.75);
        apply.setApplyDate(new Date(System.currentTimeMillis()));
        apply.setName("Tati");
        apply.setWaterAddress("渤海");
        apply.setNumber("33333333333");
        apply.setUser(userDao.get("FluteRRR"));
        apply.setState(0);
        applyDao.save(apply);
    }

    /**
     * 删除apply 不存在返回false
     *
     * @param id
     * @return
     */
    public boolean deleteApply(Long id) {
        if (applyDao.get(id) == null)
            return false;
        applyDao.delete(id);
        return true;
    }

    /**
     * 根据用户id返回申请列表
     * @param idUser
     * @return
     */
    public ArrayList<Apply> searchApplicationByUser(String idUser) {
        System.out.println("xx");
        List<Apply> list1 = applyDao.findApplyById(idUser);
        System.out.println("$$$$$$$$$$$$$$$");
        ArrayList<Apply> list2 = new ArrayList<Apply>();
        for(Apply temp : list1){
                list2.add(temp);
        }
        return list2;
    }
//找申请列表
    public ArrayList<Apply> findCheckedApply(String userid, String state) {
        List<Apply> applyList=applyDao.findApplyById(userid);
        ArrayList<Apply> resultlist=new ArrayList<Apply>();
        if(state.equals("待审核")){
            for (Apply temp:applyList
                 ) {
                if(temp.getState()==0){
                    resultlist.add(temp);
                }
            }

        }
        else if(state.equals("已审核")){
            for (Apply temp:applyList
                    ) {
                if((temp.getState()==1||temp.getState()==2)&&uploadDao.findSampleById(temp.getIdApply())==null){
                    resultlist.add(temp);
                }
            }
        }
        return resultlist;


    }

    public boolean addApply(Apply apply) {
        return applyDao.save(apply);
    }

    @Override
    public boolean updateState(Long idApply, Integer state, String responce) {
        boolean result=false;
        Apply apply=applyDao.get(idApply);
        System.out.println(apply.getImage().size()+"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        if(apply==null){
            result = false;

        }else {
            apply.setState(state);
            apply.setResponse(responce);
            result=true;
        }

        return result;
    }

    /**
     * 更改状态 申请号不存在返回false
     *
     * @param id
     * @param state
     * @return
     */
    public boolean updateState(Long id, Integer state) {
        Apply apply = applyDao.get(id);
        if (apply == null)
            return false;
        apply.setState(state);
        applyDao.saveOrUpdate(apply);
        return true;
    }

    public void addApplication(Long idApply, Double longitude, Double latitude, String number, String address, Date applyDate, Integer state, List<String> image, String name, String waterAddress, String idUser) {
        Apply apply = new Apply();
        apply.setIdApply(idApply);
        apply.setLongitude(longitude);
        apply.setLatitude(latitude);
        apply.setNumber(number);
        apply.setAddress(address);
        apply.setApplyDate(applyDate);
        apply.setState(state);
        apply.setImage(image);
        apply.setName(name);
        apply.setWaterAddress(waterAddress);
        apply.getUser().setIdUser(idUser);
        applyDao.save(apply);

    }

    /**
     * 根据申请号搜索apply
     *
     * @param idApply
     * @return
     */
    public Apply searchApplication(Long idApply) {
        return applyDao.get(idApply);
    }

    /**
     * 根据状态返回apply列表
     *
     * @param state
     * @return
     */
    public ArrayList<Apply> getApplicationList(int state) {
        List<Apply> arrayList = applyDao.findAll();
        ArrayList<Apply> list = new ArrayList<Apply>();
        for (Apply temp : arrayList) {
            if (temp.getState() == state) {
                list.add(temp);
            }
        }
        return list;
    }

//    public Apply sendApplication(String idApply, Double longitude, Double latitude, String number, String address, Integer postcode, Date applyDate, Integer state, byte[] image){return null;}
//
//    public Apply addApplication(long idApply, Double longitude, Double latitude, String number, String address, Date applyDate, Integer state,String image, String name){return null;}
}
