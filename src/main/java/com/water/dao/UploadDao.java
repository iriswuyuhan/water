package com.water.dao;

import com.water.entity.Sample;

import java.util.List;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
public interface UploadDao extends  DaoUtil<Sample,Long>{
    /**
     * 通过申请编号查找样本
     * @param applyId
     * @return
     */
    public Sample findSampleById(long applyId);

}
