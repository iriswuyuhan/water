package com.water.dao;

import com.water.entity.Apply;

import java.util.ArrayList;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
public interface ApplyDao extends  DaoUtil<Apply,Long>{
    /**
     * 修改申请状态
     *
     * @param idApply
     * @param state
     */
    public void updateState(long idApply, Integer state);
    /**
     * 通过id查询申请
     *
     * @param idApply
     * @return
     */
    public ArrayList<Apply> searchApplicationById(Long idApply);

}
