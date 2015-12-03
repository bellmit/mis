package com.syzc.mis.service;

import com.syzc.mis.entity.disease.Hspn;
import com.syzc.mis.entity.filter.BaseFilter;
import com.syzc.util.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BaseServiceM<T, Q extends PagingAndSortingRepository<T, String>> {
    T save(T entity);

    void delete(String id);

    T findOne(String id);

    Page<T> findAll(Integer pageNo, Integer size);

    Page<T> filter(BaseFilter filter, Integer pageNo, Integer size);
}