package com.water.service.Impl;

import com.water.service.TService;
import org.springframework.stereotype.Service;

/**
 * Created by XRog
 * On 2/1/2017.12:58 AM
 */
@Service
public class TServiceImpl implements TService {
    public String test() {
        return "test";
    }
}