package com.syzc.mis.dao.repo;

import com.syzc.mis.entity.disease.Hspn;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HspnRepo extends PagingAndSortingRepository<Hspn, String> {
}