package com.tylerholcombe.celebritydeathpoolservice.repository;

import com.tylerholcombe.celebritydeathpoolservice.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntryRepository extends JpaRepository<Entry, Integer> {
    List<Entry> findByIsApproved(boolean isApproved);
}
