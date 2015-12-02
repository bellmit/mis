package com.syzc.mis.controller;

import com.syzc.mis.service.UserService;
import com.syzc.util.UrlComponentUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = Logger.getLogger(LoginController.class);
    @Resource
    UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Long id = (Long) session.getAttribute("loginUserId");

        StringBuilder refer = new StringBuilder();
        {
            refer.append(request.getRequestURL()); // just a name for login page's redirect
            if (request.getQueryString() != null) {
                refer.append('?');
                refer.append(request.getQueryString());
            }
//            logger.trace(String.format("%d - %s", id, refer.toString()));
        }
        if (id == null) {
            response.sendRedirect(request.getContextPath() + "/login?refer=" + UrlComponentUtil.encoding(refer.toString()));
            return false;
        }
        session.setAttribute("loginUser", userService.get(id));
        return super.preHandle(request, response, handler);
    }
}