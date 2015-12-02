package com.syzc.mis.dao;

import com.alibaba.fastjson.JSON;
import com.syzc.mis.dao.repo.HspnRepo;
import com.syzc.util.LocalAcUtil;
import org.springframework.data.domain.PageRequest;

public class HspnRepoTestD {
    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(LocalAcUtil.getAc().getBeanDefinitionNames(), true));
        HspnRepo repo = (HspnRepo) LocalAcUtil.getAc().getBean("hspnRepo");
        System.out.println(JSON.toJSONString(repo.findAll(), true));

        repo.findAll(new PageRequest(1, 10));
    }
}