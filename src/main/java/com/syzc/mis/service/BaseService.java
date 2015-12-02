package com.syzc.mis.service;

import com.syzc.mis.dao.mysql.BaseDao;
import com.syzc.util.Page;

import java.util.List;

public interface BaseService<T, Q extends BaseDao<T>> {
    T add(T entity);

    Boolean remove(Long id);

    Boolean update(T entity);

    T get(Long id);

    Page<T> list(Integer pageNo, Integer size);

    List<T> listAll();
}