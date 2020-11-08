package com.tylerholcombe.celebritydeathpoolservice.repository;

import com.tylerholcombe.celebritydeathpoolservice.model.Entry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntryRepository extends CrudRepository<Entry, Integer> {
    List<Entry> findByIsApproved(boolean isApproved);
}
