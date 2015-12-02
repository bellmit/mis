package com.syzc.mis.controller;

import com.alibaba.fastjson.JSON;
import com.syzc.mis.entity.User;
import com.syzc.mis.service.UserService;
import com.syzc.util.HosException;
import com.syzc.util.Page;
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
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/user")
public class UserController {
    protected static final Pattern idNPattern = Pattern.compile("\\d{17}[\\dxX]");
    private static final Logger logger = Logger.getLogger(UserController.class);
    public final Integer pageSize = 20;
    public final Short pageSizeS = 20;

    private UserService userService;

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // update others
    @RequestMapping(value = "/update/{userid:[\\d]+}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("userid") Long userId, Model model, HttpServletRequest request, HttpSession session) {

//        System.out.println(JSON.toJSONString(loginUser, true));


        //合并了不同种类操作； 普通雇员只能修改自己的资料

        String referer = request.getHeader("Referer");
        if (referer == null) {
            referer = "/";
        }
        User user = userService.get(userId);
        if (user == null) {
            throw HosException.create("对应的用户不存在", Level.TRACE);
        }
        model.addAttribute("user", user);
        model.addAttribute("referer", referer);
        model.addAttribute("path", "/users/update");
        return "/user-update";
    }

    @RequestMapping(value = "/update/{userid:[\\d]+}", method = RequestMethod.POST)
    public String updateUser(@PathVariable("userid") Long userId, @RequestParam("referer") String referer, User user, Model model, HttpSession session) {
        user.setId(userId);

        boolean state;
        state = userService.updateInfo(user);
//            state = userService.update(user);
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

    /*@RequestMapping(value = "/remove/{userid:[\\d]+}")
    public String removeUser(@PathVariable("userid") Long userId, HttpServletRequest request, HttpSession session) {

        UserDto loginUser = (UserDto) session.getAttribute("loginUser");
        *//*if (loginUser.getRole() == null || (loginUser.getRole() != Role.ADMIN && loginUser.getRole() != Role.MANAGER)) {
            throw AuthException.create("没有权限", Level.DEBUG);
        }*//*
        if (loginUser.getRole() == null || (loginUser.getRole() != Role.ADMIN)) {
            throw AuthException.create("没有权限", Level.DEBUG);
        }

        String referer = request.getHeader("Referer");
        if (referer == null) {
            referer = "/";
        }
        if (userService.remove(userId)) {
//            model.addAttribute("success", "移除完成！");
            return "redirect:" + referer;
        } else {
            throw HosException.create("删除用户操作没有执行成功", Level.WARN);
        }
    }*/

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String removeUserPost(@RequestParam("id") Long userId, HttpServletRequest request, HttpSession session) {
        String referer = request.getHeader("Referer");
        if (referer == null) {
            referer = "/";
        }
        if (userService.remove(userId)) {
//            model.addAttribute("success", "移除完成！");
            return "redirect:" + referer;
        } else {
            throw HosException.create("删除用户操作没有执行成功", Level.WARN);
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser(Model model, HttpSession session) {
        return "/user-add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(User form, @RequestParam("confirmPwd") String confirmPwd, Model model, HttpSession session) {
        boolean state = true;
        List<String> errors = new LinkedList<>();
        if (form.getPassword() == null || !form.getPassword().equals(confirmPwd)) {
            errors.add("密码不匹配");
            state = false;
        }

        try {
            InetAddress.getByName(form.getLimitedIp());
        } catch (UnknownHostException e) {
            errors.add("IP地址格式错误");
            state = false;
        }

/*
        Matcher m = idNPattern.matcher(form.getIdNumber());
        if (!m.matches()) {
            errors.add("身份证号码格式错误");
            logger.trace("错误的身份证号码: " + form.getIdNumber());
            state = false;
        }
        int age = form.getAge();
        int calcAge = AgeUtil.calc(form.getIdNumber());
        if (age != calcAge) {
            errors.add("身份证年龄不匹配");
            logger.trace(String.format("错误的身份证号码与年龄关系: %s,\t%s", form.getIdNumber(), age));
            state = false;
        }
*/

        if (!state) {
//            System.out.println(JSON.toJSONString(errors, true));
            model.addAttribute("form", form);
            model.addAttribute("errors", errors);
            return "/user-add";
        }
        User result;
        result = userService.add(form);
        if (result == null) {
            model.addAttribute("error", "添加用户错误");
            model.addAttribute("form", result);
            return "/user-add";
        } else {
            return "redirect:/user/list/1";
        }
    }

    @RequestMapping("/list/{page:\\d+}")
    public String list(@PathVariable("page") Integer pageNo, Model model, HttpSession session) {
        Page<User> page;
//        page = userService.listByGroup(loginUser.getGroupId(), pageNo, pageSize);
        page = userService.list(pageNo, pageSize);
        model.addAttribute("page", page);
        model.addAttribute("path", "/user/list");
        return "/user-list";
    }

    @RequestMapping(value = "profile/{id:\\d+}")
    public String profile(@PathVariable("id") Long userId, Model model, HttpSession session) {

        Long loginUserId = (Long) session.getAttribute("loginUserId");
        User user = userService.get(userId);

        //主任查看本部门用户资料
        /*if (loginUser.getRole() == Role.DIRECTOR && user != null && !loginUser.getGroupId().equals(user.getGroupId())) {
            throw AuthException.create("没有权限", Level.DEBUG);
        }*/

        if (user == null) {
            throw HosException.create("查无此人", Level.DEBUG);
        }

        model.addAttribute("user", user);
        return "/user-m-profile";
    }

    @RequestMapping(value = "profile")
    public String profile(Model model, HttpSession session) {
        Long loginUserId = (Long) session.getAttribute("loginUserId");
        User user = userService.get(loginUserId);
        session.setAttribute("loginUser", user);

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
/*
        if (newPassword.length()<6) {
            throw HosException.create("新密码长度太小", Level.DEBUG);
        }
*/
        Long userId = (Long) session.getAttribute("loginUserId");
        if (userService.updatePassword(userId, oldPassword, newPassword)) {
            return "redirect:/";
        } else {
            throw HosException.create("密码更改失败", Level.DEBUG);
        }
    }

    @RequestMapping(value = "reset-password/{userId:\\d+}", method = RequestMethod.GET)
    public String resetPassword(@PathVariable Long userId, String referer, Model model, HttpSession session, HttpServletRequest request) {
        User currentUser = (User) session.getAttribute("loginUser");
        User targetUser = userService.get(userId);
        if (targetUser == null) {
            throw HosException.create("用户不存在", Level.DEBUG);
        }
        if (referer == null) {
            referer = request.getHeader("Referer");
            if (referer == null) {
                referer = "/";
            }
        }
        model.addAttribute("user", targetUser);
        model.addAttribute("referer", referer);
        return "user-password-reset";
    }

    @RequestMapping(value = "reset-password/{userId:\\d+}", method = RequestMethod.POST)
    public String resetPassword(@PathVariable Long userId, String referer, String newPassword, String confirmPassword, HttpSession session) {
        User currentUser = (User) session.getAttribute("loginUser");
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