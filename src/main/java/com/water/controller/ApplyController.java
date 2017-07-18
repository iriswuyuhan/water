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
     * @return 登录验证
     * @throws Exception
     */
    @RequestMapping("/applylist")
    public void applylist(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.print(123);
        String state = request.getParameter("name" );
        ApplyService applyService = new ApplyServiceImpl();
        ArrayList<ApplyEntity> arrayList= applyService.getApplicationList(state);
        ApplyEntity applyEntity = new ApplyEntity();
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

}
