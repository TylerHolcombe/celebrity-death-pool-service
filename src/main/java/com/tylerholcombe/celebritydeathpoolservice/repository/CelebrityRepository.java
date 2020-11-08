package com.tylerholcombe.celebritydeathpoolservice.repository;

import com.tylerholcombe.celebritydeathpoolservice.model.Celebrity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CelebrityRepository extends JpaRepository<Celebrity, Integer> {
}
