package com.syzc.mis.controller;

import com.syzc.mis.entity.User;
import com.syzc.mis.service.UserService;
import com.syzc.util.HosException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);
    public final Integer pageSize = 20;

    private UserService userService;

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateUser(Model model, HttpServletRequest request, HttpSession session) {
        String referer = request.getHeader("Referer");
        if (referer == null) {
            referer = "/default";
        }

        User loginUser = (User) session.getAttribute("loginUser");

        model.addAttribute("user", loginUser);
        model.addAttribute("referer", referer);
        return "/user-update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(String referer, User user, Model model, HttpSession session) {
        Long loginUserId = (Long) session.getAttribute("loginUserId");

        boolean state;
        user.setId(loginUserId);
        state = userService.updateInfo(user);
        if (state) {
            user = userService.get(loginUserId);
            model.addAttribute("user", user);
            model.addAttribute("referer", referer);
            model.addAttribute("success", "修改完成！");
            return "/user-update";
        } else {
            throw HosException.create("管理员修改用户信息错误", Level.WARN);
        }
    }

    @RequestMapping(value = "profile")
    public String profile(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        if (user == null) {
            throw HosException.create("查无此人", Level.DEBUG);
        }

        model.addAttribute("user", user);
        return "/profile-self";
    }

    @RequestMapping(value = "update-password", method = RequestMethod.GET)
    public String updatePassword(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        model.addAttribute("user", user);
        return "user-update-password";
    }

    @RequestMapping(value = "update-password", method = RequestMethod.POST)
    public String updatePassword(String oldPassword, String newPassword, String confirmPassword, HttpSession session) {
        if (!newPassword.equals(confirmPassword)) {
            throw HosException.create("确认密码不匹配", Level.DEBUG);
        }
        //需要检查密码强度

        User loginUser = (User) session.getAttribute("loginUser");
        if (userService.updatePassword(loginUser.getUsername(), oldPassword, newPassword)) {
            //成功修改了密码
            return "redirect:profile";
        } else {
            throw HosException.create("密码更改失败", Level.DEBUG);
        }
    }
}