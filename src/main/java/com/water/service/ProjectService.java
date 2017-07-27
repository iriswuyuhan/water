package com.water.service;

public interface ProjectService {
    boolean uploadPicture(byte[][] picture);
    boolean deletePicture();
    boolean publishProject(String headline,String body);
    boolean deleteProject(String headline);
    boolean modifyProject(String headline,String body);
}
