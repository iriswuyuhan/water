package com.water.service;

import com.water.entity.Apply;

import java.util.ArrayList;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
public interface ApplyService {

    /**
     * 更新申请状态
     * @param id
     * @param state
     * @return
     */
    public boolean updateState(Long id,Integer state);

    /**
     * 根据申请编号找申请
     * @param idApply
     * @return
     */
    public Apply searchApplication(Long idApply);

    /**
     * 返回某一状态下的申请列表
     * @param state
     * @return
     */
    public ArrayList<Apply> getApplicationList(int state);

    /**
     * 删除申请
     * @param id
     * @return
     */
    public boolean deleteApply(Long id);

    /**
     * 根据用户id返回申请列表
     * @param idUser
     * @return
     */
    public ArrayList<Apply> searchApplicationByUser(String idUser);

    /**
     * 返回某一用户不同状态的申请列表
     * @param userid
     * @param state
     * @return
     */
    public ArrayList<Apply> findCheckedApply(String userid,String state);

    /**
     * 添加申请
     * @param apply
     * @return
     */
    public boolean addApply(Apply apply);

    /**
     * 更新申请状态并返回回复
     * @param idApply
     * @param state
     * @param responce
     * @return
     */
    public boolean updateState(Long idApply,Integer state,String responce );
}
