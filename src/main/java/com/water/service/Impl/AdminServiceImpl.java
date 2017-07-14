package com.water.service.Impl;
import com.water.dao.AdminDao;
import com.water.entity.Admin;
import com.water.entity.Record;
import com.water.entity.Sample;
import com.water.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bxh on 2017/7/14.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    public void Login(Admin admin){}
    public void Logout(Admin admin){}
    public Sample processRequest(Sample sample){return null;}
    public List<Sample> checkAllSample(){return null;}
    public List<Record> checkAllRecord(){return null;}
}