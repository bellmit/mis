package com.syzc.mis.service;

import com.syzc.mis.entity.filter.BaseFilter;
import com.syzc.util.Page;
import com.syzc.util.PageUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public abstract class BaseServiceMImpl<T, Q extends PagingAndSortingRepository<T, String>> implements BaseServiceM<T, Q> {
    MongoTemplate mongoTemplate;
    Q repo;

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void setRepo(Q repo) {
        this.repo = repo;
    }

    @Override
    public T save(T entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(String id) {
        repo.delete(id);
    }

    @Override
    public T findOne(String id) {
        return repo.findOne(id);
    }

    @Override
    public Page<T> findAll(Integer pageNo, Integer size) {
        Long total = repo.count();
        Page page = PageUtil.make(pageNo, size, total);
        page.setList(repo.findAll(new PageRequest(page.getPageNo() - 1, page.getPageSize())).getContent());
        return page;
    }

    @Override
    public List<T> filter(BaseFilter filter, Long pageNo, Integer size) {
        return null;
    }
}