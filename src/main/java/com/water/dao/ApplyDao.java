package com.water.dao;

import com.water.model.ApplyEntity;
import com.water.model.ApplyEntity;

import java.util.ArrayList;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
public interface ApplyDao extends  DaoUtil<ApplyEntity,Long>{
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
    public ArrayList<ApplyEntity> searchApplicationById(Long idApply);

}
