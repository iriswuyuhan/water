package com.water.service.Impl;

import com.water.service.ProjectService;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    public boolean uploadPicture(byte[][] picture) {
        return false;
    }

    public boolean deletePicture() {
        return false;
    }

    public boolean publishProject(String headline, String body) {
        return false;
    }

    public boolean deleteProject(String headline) {
        return false;
    }

    public boolean modifyProject(String headline, String body) {
        return false;
    }
}
