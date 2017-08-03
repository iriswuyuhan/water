package com.water.dao;

import com.water.entity.Apply;

import java.util.List;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
public interface ApplyDao extends  DaoUtil<Apply,Long>{
    /**
     * 通过用户ID找到该用户下所有申请
     * @param idUser
     * @return
     */
    public List<Apply> findApplyById(String idUser);
    public List<String> findAllByState(int state) ;
    /**
     * 更新申请状态 0待申请 1审核通过 2拒绝申请
     * @param id
     * @param state
     * @return
     */
    public boolean updateState(long id, int state);

    /**
     * 查找某一经纬度处的申请
     * @param longi
     * @param lati
     * @return
     */
    public Apply getApplyByLocation(double longi,double lati);
}
