package com.water.service.Impl;

import com.water.dao.ApplyDao;
import com.water.dao.UploadDao;
import com.water.entity.Sample;
import com.water.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
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

    @Autowired
    private ApplyDao applyDao;

    public void addUpload() {
        Sample sample = new Sample();
        sample.setIdSample(Long.valueOf(1564655));
        sample.setRemark("666");
        sample.setApply(applyDao.get(Long.valueOf(66666666)));
        sample.setVolume(88.5);
        uploadDao.save(sample);
    }

    public void addUpload(Long idSample, Double longitude, Double latitude, Date sampleDate, Double volume, String image, String remark) {
        Sample sampleEntity = new Sample();
        sampleEntity.setIdSample(idSample);
        sampleEntity.setSampleDate(sampleDate);
        sampleEntity.setVolume(volume);
        //        sampleEntity.setImage(image);
        sampleEntity.setRemark(remark);
        uploadDao.save(sampleEntity);
    }

    public boolean addUpload(Sample sample) {
        return uploadDao.save(sample);
    }

    public Sample searchSample(Long idSample) {
        Sample sample = uploadDao.get(idSample);
        return sample;
    }

    public ArrayList<Sample> alreadySample(String userid) {
        ArrayList<Sample> resultlist = new ArrayList<Sample>();
        List<Sample> list = uploadDao.findAll();
        for (Sample temp : list
                ) {
            if (temp.getApply().getUser().getIdUser() .equals(userid)) {
                resultlist.add(temp);
            }
        }

        return resultlist;
    }

    public ArrayList<Sample> findAll() {

        ArrayList<Sample> list = new ArrayList<Sample>();
        for (Sample temp : uploadDao.findAll()) {
            list.add(temp);

        }
        return list;
    }

    public void addTxt(Sample sample) {
        try {
            // FileOutputStream file1 = new FileOutputStream("F:\\拙劣工程师\\water\\src\\main\\webapp\\resources\\txt\\new.txt");
            FileOutputStream file1 = new FileOutputStream("/home/samples/" + sample.getApply().getIdApply() + ".txt");
            OutputStreamWriter oStreamWriter = new OutputStreamWriter(file1, "utf-8");
            String id = "样本编号： " + sample.getIdSample() + "\r\n";
            String name = "申请人姓名： " + sample.getApply().getName() + "\r\n";
            String applyid = "申请编号：  " + sample.getApply().getIdApply() + "\r\n";
            String applytime = "申请时间： " + sample.getApply().getApplyDate() + "\r\n";
            String sampletime = "采样时间： " + sample.getSampleDate() + "\r\n";
            String remark = "备注： " + sample.getRemark() + "\r\n";
            String volume = "体积： " + sample.getVolume() + "\r\n";
            String phone = "联系方式： " + sample.getApply().getNumber() + "\r\n";
            String address = "水域地址： " + sample.getApply().getWaterAddress() + "\r\n";
            String lon = "经度： " + sample.getApply().getLongitude() + "\r\n";
            String lan = "纬度： " + sample.getApply().getLatitude() + "\r\n";
            oStreamWriter.write(id);
            oStreamWriter.write(name);
            oStreamWriter.write(applyid);
            oStreamWriter.write(phone);
            oStreamWriter.write(applytime);
            oStreamWriter.write(sampletime);
            oStreamWriter.write(volume);
            oStreamWriter.write(address);
            oStreamWriter.write(lon);
            oStreamWriter.write(lan);
            oStreamWriter.write(remark);
            oStreamWriter.flush();
            oStreamWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
