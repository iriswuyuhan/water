package com.water.service.Impl;

import com.water.dao.UploadDao;
import com.water.entity.Sample;
import com.water.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private UploadDao uploadDao;

    public void addUpload() {
        Sample sample = new Sample();
        sample.setIdSample(Long.valueOf(1564654));
        sample.setImage("dsfasdfasg");
        sample.setLatitude(5.65446);
        sample.setLongitude(8.546);
        sample.setRemark("23333");
        sample.setVolume(2.454);
        uploadDao.save(sample);
    }

    public void addUpload(Long idSample, Double longitude, Double latitude, Date sampleDate, Double volume, String image, String remark) {
        Sample sampleEntity = new Sample();
        sampleEntity.setIdSample(idSample);
        sampleEntity.setLongitude(longitude);
        sampleEntity.setLatitude(latitude);
        sampleEntity.setSampleDate(sampleDate);
        sampleEntity.setVolume(volume);
        sampleEntity.setImage(image);
        sampleEntity.setRemark(remark);
        uploadDao.save(sampleEntity);
    }

    public boolean addUpload(Sample sample) {

        return uploadDao.save(sample);
    }

    public ArrayList<Sample> searchSample(Long idSample) {
        List<Sample> list1 = uploadDao.findAll();
        ArrayList<Sample> list2 = new ArrayList<Sample>();
        for(Sample temp:list1){
            if(temp.getIdSample()==idSample){
                list2.add(temp);
            }
        }
        return list2;
    }

    public ArrayList<Sample> alreadySample() {
       List<Sample> list=uploadDao.findAll();


        return null;
    }

    public ArrayList<Sample> findAll() {

        ArrayList<Sample> list=new ArrayList<Sample>();
        for(Sample temp:uploadDao.findAll()){
            list.add(temp);

        }
        return list;
    }
}
