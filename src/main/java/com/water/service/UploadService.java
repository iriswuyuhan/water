package com.water.service;

import com.water.entity.Sample;

import java.util.ArrayList;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
public interface UploadService {

    /**
     * 更新样本状态
     * @param idSample
     * @param state
     * @return
     */
    public boolean updateSample(long idSample, int state);

    /**
     * 上传采样信息（增加样本）
     * @param sample
     * @return
     */
    public boolean addUpload(Sample sample);

    /**
     * 通过样本ID获得样本
     * @param idSample
     * @return
     */
    public Sample searchSample(Long idSample);

    /**
     * 获取某一用户已采样样本列表
     * @param userid
     * @return
     */
    public ArrayList<Sample> alreadySample(String userid);

    /**
     * 返回所有样本列表
     * @return
     */
    public ArrayList<Sample> findAll();

    /***
     * 将样本信息保存为txt
     * @param sample
     */
    public void addTxt(Sample sample);

    /**
     * 根据id判断样本是否存在 若存在返回状态值 不存在返回-1
     * @param id
     * @return
     */
    public int judgeByID(long id);

}
