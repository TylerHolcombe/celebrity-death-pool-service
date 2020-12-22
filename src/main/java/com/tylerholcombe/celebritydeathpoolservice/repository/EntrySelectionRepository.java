package com.tylerholcombe.celebritydeathpoolservice.repository;

import com.tylerholcombe.celebritydeathpoolservice.model.EntrySelection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrySelectionRepository extends JpaRepository<EntrySelection, Integer> {
}
