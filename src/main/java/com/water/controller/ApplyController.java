package com.water.controller;

import com.water.entity.Apply;
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
        String state = request.getParameter("state" );
        int state1 =0;
        if(state.equals("审核通过"))
            state1=1;
        if (state.equals("未通过审核"))
            state1=2;
        ApplyService applyService = new ApplyServiceImpl();
        ArrayList<Apply> arrayList= applyService.getApplicationList(state1);
//        Apply apply = new Apply();
//        apply.setIdApply(123456789);
//        apply.setState(0);
//        apply.setAddress("sadasdasdafa");
//        apply.setLatitude(32123.22);
//        apply.setLongitude(253.22);
//        apply.setNumber("2512156");
//        apply.setIdApply(123456789);
//        ArrayList<Apply> list =new  ArrayList<Apply>();
//
//        list.add(apply);
//        list.add(apply);
//        list.add(apply);
//        list.add(apply);
//        list.add(apply);
//        list.add(apply);
//        list.add(apply);
//        list.add(apply);
        JSONArray array = JSONArray.fromObject(arrayList);
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
//        Apply apply = new Apply();
//        apply.setIdApply(123456789);
//        apply.setAddress("江苏省");
//        apply.setLatitude(32123.22);
//        apply.setState(0);
//        apply.setLongitude(253.22);
//        apply.setNumber("2512156");
        long id1 = Integer.parseInt(id);
        Apply apply = applyService.searchApplication(id1);
       JSONObject object = JSONObject.fromObject(apply);
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
        int state1 = Integer.parseInt(state);
        ApplyService applyService = new ApplyServiceImpl();
        boolean bool = applyService.updateState(id,state1);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print("success");
    }
}
