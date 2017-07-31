package com.water.service.Impl;

import com.water.dao.ApplyDao;
import com.water.dao.ResultDao;
import com.water.dao.UploadDao;
import com.water.entity.Apply;
import com.water.entity.Result;
import com.water.entity.Sample;
import com.water.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhanglei on 2017/7/27.
 */
@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultDao resultDao;

    @Autowired
    private UploadDao uploadDao;

    @Autowired
    private ApplyDao applyDao;

    @Override
    public boolean addResult(Result result) {
        return resultDao.save(result);
    }


    @Override
    public Result findResultByID(long idResult){
        return resultDao.get(idResult);
    }

    @Override
    public boolean modifyResult(Long idSample, String text) {
        Result result = resultDao.get(idSample);
        if(result==null){
            return  false;

        }else {
            result.setDescription(text);
            resultDao.saveOrUpdate(result);
            return  true;
        }

    }

    @Override
    public Result getResultbyLocation(double longitude, double latitude) {
        Apply apply=applyDao.getApplyByLocation(longitude,latitude);
        Sample sample=uploadDao.findSampleById(apply.getIdApply());
        Result result=resultDao.get(sample.getIdSample());
        return result;
    }


}
