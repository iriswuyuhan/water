package com.water.service.Impl;

import com.water.dao.SampleDao;
import com.water.entity.Record;
import com.water.entity.Sample;
import com.water.entity.User;
import com.water.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asus1 on 2017/7/14.
 */
@Service
public class SampleServiceImpl implements SampleService {
    @Autowired
    private SampleDao sampleDao;

    public List<Sample> showSamples(){return null;}
}
