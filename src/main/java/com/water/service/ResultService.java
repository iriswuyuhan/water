package com.water.service;

import com.water.entity.Result;

/**
 * Created by zhanglei on 2017/7/27.
 */
public interface ResultService {
    /**
     * 上传样本实验结果
     * @param result
     * @return
     */
    public boolean addResult(Result result);

    /**
     * 通过样本id查找实验结果
     * @param idResult
     * @return
     */
    public Result findResultByID(long idResult);

    /**
     * 修改实验结果
     * @param idSample
     * @param text
     * @return
     */
    public boolean modifyResult(Long idSample, String text);

    /**
     * 通过经纬度确定样本返回实验结果
     * @param longitude
     * @param latitude
     * @return
     */
    public Result getResultbyLocation(double longitude,double latitude);
}
