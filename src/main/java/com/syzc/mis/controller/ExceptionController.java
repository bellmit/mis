package com.syzc.mis.controller;

import com.syzc.util.HosException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Controller
public class ExceptionController {
    private Logger logger = Logger.getLogger(ExceptionController.class);

    @RequestMapping(value = "/login/e")
    String e() throws Exception {
        throw new Exception("抛出自定义异常");
    }

    @ExceptionHandler({Exception.class, HosException.class})
    public String exp(Exception ex, HttpServletRequest request) {
        if (ex instanceof HosException) {
            logger.log(((HosException) ex).getLevel(), ex);
        } else {
            logger.debug(ex);
        }
        request.setAttribute("ex", ex);
        return "/exception-caught";
    }
}