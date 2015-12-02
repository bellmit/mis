package com.syzc.mis.service;

import com.alibaba.fastjson.JSON;
import com.syzc.util.LocalAcUtil;

public class HspnServiceImplTestB {
    public static void main(String[] args) {
        HspnService service = (HspnService) LocalAcUtil.getAc().getBean("hspnServiceImpl");
        System.out.println(JSON.toJSONString(service.findOne("565e560c77ede5916634636a"), true));
    }
}