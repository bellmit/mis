package com.syzc.mis.service;

import com.syzc.mis.dao.repo.HspnRepo;
import com.syzc.mis.entity.disease.Hspn;
import com.syzc.mis.entity.filter.BaseFilter;
import com.syzc.util.Page;
import com.syzc.util.PageUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

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

    @Override
    public Page<Hspn> filter(BaseFilter filter, Integer pageNo, Integer size) {
        Criteria c = null;

        List<Criteria> cl = new LinkedList<>();
        if (filter.getSex() != null) {
            cl.add(Criteria.where("profile.sex").is(filter.getSex()));
        }
        if (filter.getAgeOfOnset() != null) {
            cl.add(Criteria.where("profile.ageOfOnset").is(filter.getAgeOfOnset()));
        }
        if (filter.getAgeOfOnsetMax() != null) {
            cl.add(Criteria.where("profile.ageOfOnset").lte(filter.getAgeOfOnsetMax()));
        }
        if (filter.getAgeOfOnsetMin() != null) {
            cl.add(Criteria.where("profile.ageOfOnset").gte(filter.getAgeOfOnsetMin()));
        }
        if (filter.getAdmissionDate() != null) {
            cl.add(Criteria.where("profile.admissionDate").is(filter.getAdmissionDate()));
        }
        if (filter.getAdmissionDateMax() != null) {
            cl.add(Criteria.where("profile.admissionDate").lte(filter.getAdmissionDateMax()));
        }
        if (filter.getAdmissionDateMin() != null) {
            cl.add(Criteria.where("profile.admissionDate").gte(filter.getAdmissionDateMin()));
        }
        if (cl.size() == 0) {
            c = new Criteria();
        } else {
            Criteria[] carr = new Criteria[cl.size()];
            for (int i = 0; i < cl.size(); i++) {
                carr[i] = cl.get(i);
            }
            c = new Criteria().andOperator(carr);
            System.out.println(cl.size());
        }

        Query query = new Query(c);
        System.out.println(query);
        Long total = mongoTemplate.count(query, Hspn.class);
        Page<Hspn> page = PageUtil.make(pageNo, size, total);
        List<Hspn> list = mongoTemplate.find(query.with(new PageRequest(page.getPageNo() - 1, page.getPageSize())), Hspn.class);
        page.setList(list);
        return page;
    }
}