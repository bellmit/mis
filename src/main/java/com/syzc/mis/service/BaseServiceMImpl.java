package com.syzc.mis.service;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

public class BaseServiceMImpl implements BaseServiceM<T, ID extends Serializable, Q extends PagingAndSortingRepository<T, ID>> {
    MongoTemplate setMongoTemplate() {
    }

    ;
}
