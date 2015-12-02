package com.syzc.mis.service;

import com.alibaba.fastjson.JSON;
import com.syzc.util.LocalAcUtil;

public class HspnServiceImplTest {
    public static void main(String[] args) {
        HspnService service = (HspnService) LocalAcUtil.getAc().getBean("hspnServiceImpl");
        System.out.println(JSON.toJSONString(service.findAll(1, 10), true));
    }
}