package com.water.service;

import com.water.entity.Sample;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
public interface UploadService {
    public void addUpload();

    public boolean updateSample(long idSample, int state);

    public void addUpload(Long idSample, Double longitude, Double latitude, Date sampleDate, Double volume, String image, String remark);

    public boolean addUpload(Sample sample);

    public Sample searchSample(Long idSample);

    //已采样样本
    public ArrayList<Sample> alreadySample(String userid);

    public ArrayList<Sample> findAll();

    public void addTxt(Sample sample);

   // public ArrayList<Sample> filterSample(String eventID,String startDate,String endDate);
   public int judgeByID(long id);

}
