package com.water.service;

import com.water.entity.Sample;

import java.util.Date;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
public interface UploadService {
    public void addUpload();

    public void addUpload(Long idSample, Double longitude, Double latitude, Date sampleDate, Double volume, String image, String remark);

    public boolean addUpload(Sample sample);
}
