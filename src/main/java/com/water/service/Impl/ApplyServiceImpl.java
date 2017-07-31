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
    //添加申请
    public boolean addApply(Apply apply) {
        return applyDao.save(apply);
    }


    //更新申请状态
    @Override
    public boolean updateState(Long idApply, Integer state, String responce) {
        Apply apply=applyDao.get(idApply);
        System.out.println(apply.getImage().size()+"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        if(apply==null){
            return  false;

        }else {
            apply.setState(state);
            apply.setResponse(responce);
            applyDao.saveOrUpdate(apply);
            return  true;
        }

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

}
