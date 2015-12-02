package com.syzc.mis.controller;

import com.google.code.kaptcha.Producer;
import com.syzc.mis.entity.User;
import com.syzc.mis.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@Controller
public class LoginController {
    private static final Logger logger = Logger.getLogger(LoginController.class);
    @Resource
    private UserService userService;
    @Resource
    private Producer producer;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(defaultValue = "/") String refer, HttpSession session) {
        if (session.getAttribute("loginUserId") != null) {
            return "redirect:" + refer;
        }
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, @RequestParam(defaultValue = "/welcome") String refer,
                        HttpSession session, Model model) {
        User login = userService.login(username, password);
        if (login == null) {
            model.addAttribute("error", "用户名或者密码或者接入IP有错误。是不是忘了？");

            return "/login";
        }

        session.setAttribute("loginUser", login);
        session.setAttribute("loginUserId", login.getId());
        return "redirect:" + refer;
//        ContextLoader.getCurrentWebApplicationContext().getServletContext().getServletContextName()
    }

/*
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("captcha") String captcha, @RequestParam("username") String username,
                        @RequestParam("password") String password, @RequestParam(required = false) String refer,
                        HttpSession httpSession, Model model, HttpServletRequest request) {
        String kaptcha = (String) httpSession.getAttribute("kaptcha");
        if (!captcha.equals(kaptcha)) {
            model.addAttribute("error", "验证码错误");
            return "/login";
        }

        String addr;
        addr = request.getHeader("X-Real-IP");
        if (addr == null) {
            addr = request.getHeader("X-Forwarded-For");
            if (addr == null) {
                addr = request.getRemoteAddr();
            } else {
                int idx = addr.indexOf(',');
                if (idx >= 0) {
                    addr = addr.substring(0, idx);
                }
            }
        }

        User login = userService.login(username, password, addr);
        if (login == null) {
            model.addAttribute("error", "用户名或者密码或者接入IP有错误，是不是忘了。");
//        ContextLoader.getCurrentWebApplicationContext().getServletContext().getServletContextName()
            return "/login";
        }

        httpSession.setAttribute("loginUser", login);
        httpSession.setAttribute("loginUserId", login.getId());
        if (refer != null) {
            return "redirect:" + refer;
        }
        return "redirect:/welcome";
    }
*/

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
//        return "/logout"; // View
        return "redirect:/login";
    }

/*
    @RequestMapping("/captcha")
    public String captcha(HttpSession session, HttpServletResponse response) throws IOException {
        String text = producer.createText();

        BufferedImage bufferedImage = producer.createImage(text);
        session.setAttribute("kaptcha", text);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.setContentType("image/jpeg");
        ImageIO.write(bufferedImage, "jpeg", response.getOutputStream());
        response.getOutputStream().close();
        return null;
    }
*/

    //    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "/register";
    }

    //    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("captcha") String captcha, User form, @RequestParam("confirmPwd") String confirmPwd, Model model, HttpSession httpSession) {
        String kaptcha = (String) httpSession.getAttribute("kaptcha");

        if (!captcha.equals(kaptcha)) {
            model.addAttribute("error", "验证码错误");
            return "/register";
        }

        boolean state = true;
        List<String> errors = new LinkedList<>();
        if (form.getPassword() == null || !form.getPassword().equals(confirmPwd)) {
            errors.add("密码不匹配");
            state = false;
        }

        if (!state) {
//            System.out.println(JSON.toJSONString(errors, true));
            model.addAttribute("form", form);
            model.addAttribute("errors", errors);
            return "/register";
        }
        form = userService.add(form);
        httpSession.setAttribute("loginUser", form);
        httpSession.setAttribute("loginUserId", form.getId());
        return "redirect:/welcome";
    }
}