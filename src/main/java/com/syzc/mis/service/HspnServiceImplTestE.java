package com.syzc.mis.service;

import com.alibaba.fastjson.JSON;
import com.syzc.mis.entity.disease.Hspn;
import com.syzc.util.LocalAcUtil;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;

public class HspnServiceImplTestE {
    public static void main(String[] args) {
        MongoTemplate mongoTemplate = (MongoTemplate) LocalAcUtil.getAc().getBean("mongoTemplate");
        System.out.println(JSON.toJSONString(mongoTemplate.find(new Query(new Criteria().andOperator(Criteria.where("profile.admissionDate").is(new Date(1449033661158L)))), Hspn.class), true));
        System.out.println(new Query(new Criteria().andOperator(Criteria.where("profile.admissionDate").is(new Date(1449033661158L)))));
    }
}