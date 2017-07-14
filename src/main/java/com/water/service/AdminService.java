package com.water.service;

import com.water.entity.Admin;
import com.water.entity.Record;
import com.water.entity.Sample;

import java.util.List;

/**
 * Created by asus1 on 2017/7/14.
 */
public interface AdminService {
    public void Login(Admin admin);
    public void Logout(Admin admin);
    public Sample processRequest(Sample sample);
    public List<Sample> checkAllSample();
    public List<Record> checkAllRecord();
}
