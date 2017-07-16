package com.water.service;

import com.water.entity.Admin;
import com.water.entity.Sample;

import java.util.List;

/**
 * Created by 朱晨乾 on 2017/7/16.
 */
public interface AdminService {
    public void Login(Admin admin);

    public void Logout(Admin admin);

    public Sample processRequest(Sample sample);

    public List<Sample> checkAllSample();

//    public List<Record> checkAllRecord();
}
