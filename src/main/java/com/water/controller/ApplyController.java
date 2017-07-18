package com.water.controller;

import com.water.model.ApplyEntity;
import com.water.service.ApplyService;
import com.water.service.Impl.ApplyServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import net.sf.json.JSONObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.io.IOException;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
@Controller
public class ApplyController {
    /**
     * @param request
     * @param response
     * @return 得到申请的list
     * @throws Exception
     */
    @RequestMapping("/applylist")
    public void applylist(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String state = request.getParameter("name" );
        ApplyService applyService = new ApplyServiceImpl();
        ArrayList<ApplyEntity> arrayList= applyService.getApplicationList(state);
        ApplyEntity applyEntity = new ApplyEntity();
        applyEntity.setIdApply(123456789);
        applyEntity.setState(0);
        applyEntity.setAddress("sadasdasdafa");
        applyEntity.setLatitude(32123.22);
        applyEntity.setLongitude(253.22);
        applyEntity.setNumber("2512156");
        applyEntity.setIdApply(123456789);
        ArrayList<ApplyEntity> list =new  ArrayList<ApplyEntity>();

        list.add(applyEntity);
        list.add(applyEntity);
        list.add(applyEntity);
        list.add(applyEntity);
        list.add(applyEntity);
        list.add(applyEntity);
        list.add(applyEntity);
        list.add(applyEntity);
        JSONArray array = JSONArray.fromObject(list);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(array.toString());
    }
    /**
     * @param request
     * @param response
     * @return 得到一个申请的信息
     * @throws Exception
     */
    @RequestMapping("/getApplyInfo")
    public void getSampleInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String id = request.getParameter("id" );
        ApplyService applyService = new ApplyServiceImpl();
        ApplyEntity applyEntity = new ApplyEntity();
        applyEntity.setIdApply(123456789);
        applyEntity.setAddress("江苏省");
        applyEntity.setLatitude(32123.22);
        applyEntity.setState(0);
        applyEntity.setLongitude(253.22);
        applyEntity.setNumber("2512156");
       JSONObject object = JSONObject.fromObject(applyEntity);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(object.toString());
    }
    /**
     * @param request
     * @param response
     * @return 审核申请
     * @throws Exception
     */
    @RequestMapping("/dealApply")
    public void dealApply(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String id = request.getParameter("id" );
        String state = request.getParameter("state" );
        ApplyService applyService = new ApplyServiceImpl();
        ApplyEntity applyEntity = new ApplyEntity();
        applyEntity.setIdApply(123456789);
        applyEntity.setState(0);
        applyEntity.setAddress("sadasdasdafa");
        applyEntity.setLatitude(32123.22);
        applyEntity.setLongitude(253.22);
        applyEntity.setNumber("2512156");
        JSONObject object = JSONObject.fromObject(applyEntity);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print("success");
    }
}
