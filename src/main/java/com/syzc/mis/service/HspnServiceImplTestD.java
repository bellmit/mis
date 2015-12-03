package com.syzc.mis.service;

import com.alibaba.fastjson.JSON;
import com.syzc.mis.entity.filter.BaseFilter;
import com.syzc.util.LocalAcUtil;

import java.util.Date;

public class HspnServiceImplTestD {
    public static void main(String[] args) {
        HspnService service = (HspnService) LocalAcUtil.getAc().getBean("hspnServiceImpl");
        BaseFilter bf = new BaseFilter();
        bf.setAdmissionDateMax(new Date(2449033661158L));
        bf.setAgeOfOnsetMin((short) 23);
//        bf.setAdmissionDate(new Date(1449033661158L));
        System.out.println(JSON.toJSONString(service.filter(bf, 1, 10), true));
        //admissionDate":1449033661158
    }
}