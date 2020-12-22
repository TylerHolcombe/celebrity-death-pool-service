package com.tylerholcombe.celebritydeathpoolservice.repository;

import com.tylerholcombe.celebritydeathpoolservice.model.Celebrity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CelebrityRepository extends JpaRepository<Celebrity, Integer> {
    Optional<Celebrity> findOneByCelebrityName(String celebrityName);
}
