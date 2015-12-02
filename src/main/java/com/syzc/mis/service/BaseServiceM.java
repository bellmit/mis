package com.syzc.mis.service;

import com.syzc.util.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.List;

public interface BaseServiceM<T, ID extends Serializable, Q extends PagingAndSortingRepository<T, ID>> {
    void add(T entity);

    void save(T entity);

    Boolean delete(Long id);

    T find(String id);

    Page<T> findAll(Long pageNo, Byte size);

    List<T> filter();
}