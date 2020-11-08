package com.tylerholcombe.celebritydeathpoolservice.service;

import com.tylerholcombe.celebritydeathpoolservice.model.Celebrity;
import com.tylerholcombe.celebritydeathpoolservice.model.Entry;
import com.tylerholcombe.celebritydeathpoolservice.repository.CelebrityRepository;
import com.tylerholcombe.celebritydeathpoolservice.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PlayerService {
    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private CelebrityRepository celebrityRepository;

    public List<Entry> getApprovedEntries() {
        return entryRepository.findByIsApproved(true).stream().map(Entry::syncSelections).collect(toList());
    }

    public List<Entry> getUnapprovedEntries() {
        return entryRepository.findByIsApproved(false).stream().map(Entry::syncSelections).collect(toList());
    }

    public List<Celebrity> getCelebrities() {
        return celebrityRepository.findAll();
    }
}
