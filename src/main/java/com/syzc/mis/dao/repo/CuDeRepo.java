package com.syzc.mis.dao.repo;

import com.syzc.mis.entity.CuDe;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuDeRepo extends PagingAndSortingRepository<CuDe, Long> {

}