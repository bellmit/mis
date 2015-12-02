package com.syzc.mis.dao;

import com.alibaba.fastjson.JSON;
import com.syzc.mis.dao.repo.CuDeRepo;
import com.syzc.mis.entity.CuDe;
import com.syzc.util.LocalAcUtil;

public class CuDeRepoTestC {
    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(LocalAcUtil.getAc().getBeanDefinitionNames(), true));
        CuDeRepo repo = (CuDeRepo) LocalAcUtil.getAc().getBean("cuDeRepo");
        System.out.println(JSON.toJSONString(repo.findAll(), true));
        CuDe cuDe = new CuDe(), result;
        cuDe.setId("123545");
        cuDe.setName("abcd");
        cuDe.setVal(2.33);
        result = repo.save(cuDe);
        System.out.println(JSON.toJSONString(result, true));
    }
}