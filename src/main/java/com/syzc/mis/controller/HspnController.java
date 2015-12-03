package com.syzc.mis.controller;

import com.alibaba.fastjson.JSON;
import com.syzc.mis.entity.disease.Hspn;
import com.syzc.mis.entity.filter.BaseFilter;
import com.syzc.mis.service.HspnService;
import com.syzc.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/hspn")
public class HspnController {
    private final Integer pageSize = 15;
    private HspnService hspnService;

    @Resource
    public void setHspnService(HspnService hspnService) {
        this.hspnService = hspnService;
    }

    @RequestMapping(value = "list", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String hspnList(@RequestParam(value = "page", defaultValue = "1") Integer pageNo, Model model) {
        Page<Hspn> page = hspnService.findAll(pageNo, pageSize);
        model.addAttribute("page", page);
        return JSON.toJSONString(page, true);
//        return "/hspn-list";
    }

    @RequestMapping(value = "", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String hspnFilter(@RequestParam(value = "page", defaultValue = "1") Integer pageNo, BaseFilter filter, Model model) {
        Page<Hspn> page = hspnService.findAll(pageNo, pageSize);
        model.addAttribute("page", page);
        return JSON.toJSONString(page, true);
//        return "/hspn-list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String hspnAdd() {
        return "/hspn-add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String hspnAdd(Hspn hspn) {
        Hspn result = hspnService.save(hspn);
        return "redirect:/hspn/update" + result.getId() + "?success-updated";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String hspnUpdate(@PathVariable String id, Model model) {
        Hspn one = hspnService.findOne(id);
        model.addAttribute("mcd", one);
        return "/hspn-add";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String hspnUpdate(@PathVariable String id, Hspn hspn, Model model) {
        hspn.setId(id);
        Hspn result = hspnService.save(hspn);
        model.addAttribute("mcd", result);
        return "redirect:/hspn-update/" + id + "?success-added";
    }
}