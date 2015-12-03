package com.syzc.mis.service;

import com.alibaba.fastjson.JSON;
import com.syzc.mis.entity.disease.Hspn;
import com.syzc.util.LocalAcUtil;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class HspnServiceImplTestF {
    public static void main(String[] args) {
        MongoTemplate mongoTemplate = (MongoTemplate) LocalAcUtil.getAc().getBean("mongoTemplate");
//        System.out.println(JSON.toJSONString(mongoTemplate.find(new Query(Criteria.where("profile.admissionDate").is())), true));
    }
}