package com.water.service;

import java.util.Date;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
public interface UploadService {
    public void addUpload();

    public void addUpload(long idSample, Double longitude, Double latitude, Date sampleDate, Double volume, String image, String remark);
}
