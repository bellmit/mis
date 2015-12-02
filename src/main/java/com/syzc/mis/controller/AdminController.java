package com.syzc.mis.controller;

import com.alibaba.fastjson.JSON;
import com.syzc.mis.entity.User;
import com.syzc.mis.service.UserService;
import com.syzc.util.HosException;
import com.syzc.util.Page;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private Logger logger = Logger.getLogger(AdminController.class);
    public final Integer pageSize = 20;
    private UserService userService;

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser() {
        return "/user-add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(User user, String confirmPwd, Model model) {
        boolean state = true;
        List<String> errors = new LinkedList<>();

        if (!StringUtils.equals(user.getPassword(), confirmPwd)) {
            errors.add("密码不匹配");
            state = false;
        }

        if (!state) {
            model.addAttribute("form", user);
            model.addAttribute("errors", errors);
            return "/user-add";
        }
        User result;
        result = userService.add(user);
        if (result == null) {
            model.addAttribute("form", user);
            model.addAttribute("error", "添加用户错误");
            return "/user-add";
        } else {
            return "redirect:/user/list";
        }
    }

    @RequestMapping(value = "/update/{userid:[\\d]+}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("userid") Long userId, Model model, HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        if (referer == null) {
            referer = "/default";
        }
        User user = userService.get(userId);
        if (user == null) {
            throw HosException.create("对应的用户不存在", Level.TRACE);
        }
        model.addAttribute("user", user);
        model.addAttribute("referer", referer);
        return "/user-update";
    }

    @RequestMapping(value = "/update/{userid:[\\d]+}", method = RequestMethod.POST)
    public String updateUser(@PathVariable("userid") Long userId, @RequestParam("referer") String referer, User user, Model model) {
        user.setId(userId);

        boolean state;
        state = userService.updateInfo(user);
        if (state) {
            user = userService.get(userId);
            logger.trace(JSON.toJSONString(user, true));
            model.addAttribute("user", user);
            model.addAttribute("referer", referer);
            model.addAttribute("path", "/users/update");
            model.addAttribute("success", "修改完成！");
            return "/user-update";
        } else {
            throw HosException.create("管理员修改用户信息错误", Level.WARN);
        }
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String removeUser(@RequestParam("id") Long userId, HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        if (referer == null) {
            referer = "/default";
        }
        if (userService.remove(userId)) {
            return "redirect:" + referer;
        } else {
            throw HosException.create("删除用户操作没有执行成功", Level.WARN);
        }
    }

    @RequestMapping(value = "profile/{id:\\d+}")
    public String profile(@PathVariable("id") Long userId, Model model) {
        User user = userService.get(userId);

        if (user == null) {
            throw HosException.create("查无此人", Level.DEBUG);
        }

        model.addAttribute("user", user);
        return "/user-profile";
    }

    @RequestMapping("/list")
    public String list(@RequestParam(value = "page", defaultValue = "1") Integer pageNo, Model model) {
        Page<User> page;
//        page = userService.listByGroup(loginUser.getGroupId(), pageNo, pageSize);
        page = userService.list(pageNo, pageSize);
        model.addAttribute("page", page);
        model.addAttribute("path", "/user/list");
        return "/user-list";
    }

    @RequestMapping(value = "reset-password/{userId:\\d+}", method = RequestMethod.GET)
    public String resetPassword(@PathVariable Long userId, String referer, Model model, HttpServletRequest request) {
        User targetUser = userService.get(userId);
        if (targetUser == null) {
            throw HosException.create("用户不存在", Level.DEBUG);
        }
        if (referer == null) {
            referer = request.getHeader("Referer");
            if (referer == null) {
                referer = "/default";
            }
        }
        model.addAttribute("user", targetUser);
        model.addAttribute("referer", referer);
        return "user-password-reset";
    }

    @RequestMapping(value = "reset-password/{userId:\\d+}", method = RequestMethod.POST)
    public String resetPassword(@PathVariable Long userId, String referer, String newPassword, String confirmPassword) {
        if (!newPassword.equals(confirmPassword)) {
            throw HosException.create("确认密码不匹配", Level.DEBUG);
        }
        if (userService.updateResetPassword(userId, newPassword)) {
            if (referer == null) {
                referer = "/default";
            }
            return "redirect:" + referer;
        } else {
            return String.format("redirect:/user/reset-password/%d?error", userId);
        }
    }
}