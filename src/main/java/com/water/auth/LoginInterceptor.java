package com.water.auth;

import com.water.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * author: ysk13
 * date: 2017-5-4
 * description:
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());
        String params = request.getQueryString();

        if (url.startsWith("/toAdmin.do") || url.startsWith("/toAdmin_Sample_Result.do") || url.startsWith("/toAdmin_Sample.do") || url.startsWith("/toAdmin_Project.do")) {
            User user = (User) request.getSession().getAttribute("auth");
            if (user == null) {
                String gotoUrl = url;
                if (params != null && !"".equals(params)) {
                    gotoUrl = gotoUrl + "?" + params;
                }
                try {
                    gotoUrl = URLEncoder.encode(gotoUrl, "utf-8");
                } catch (UnsupportedEncodingException ignored) {
                }

                request.getSession().setAttribute("goto", gotoUrl);
                request.getRequestDispatcher("/Admin").forward(request, response);
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
