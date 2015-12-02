package com.syzc.mis.service;

import com.syzc.mis.dao.repo.HspnRepo;
import com.syzc.mis.entity.disease.Hspn;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HspnServiceImpl extends BaseServiceMImpl<Hspn, HspnRepo> implements HspnService {

    @Resource
    @Override
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        super.setMongoTemplate(mongoTemplate);
    }

    @Resource
    @Override
    public void setRepo(HspnRepo repo) {
        super.setRepo(repo);
    }
}