package com.syzc.mis.service;

import com.syzc.mis.entity.filter.BaseFilter;
import com.syzc.util.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BaseServiceM<T, Q extends PagingAndSortingRepository<T, String>> {
    T save(T entity);

    void delete(String id);

    T findOne(String id);

    Page<T> findAll(Integer pageNo, Integer size);

    List<T> filter(BaseFilter filter, Long pageNo, Integer size);
}