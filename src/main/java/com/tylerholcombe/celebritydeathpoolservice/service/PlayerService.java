package com.tylerholcombe.celebritydeathpoolservice.service;

import com.tylerholcombe.celebritydeathpoolservice.model.Celebrity;
import com.tylerholcombe.celebritydeathpoolservice.model.Entry;
import com.tylerholcombe.celebritydeathpoolservice.model.Player;
import com.tylerholcombe.celebritydeathpoolservice.repository.CelebrityRepository;
import com.tylerholcombe.celebritydeathpoolservice.repository.EntryRepository;
import com.tylerholcombe.celebritydeathpoolservice.repository.EntrySelectionRepository;
import com.tylerholcombe.celebritydeathpoolservice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private EntrySelectionRepository entrySelectionRepository;

    @Autowired
    private CelebrityRepository celebrityRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public List<Entry> getApprovedEntries() {
        return entryRepository.findByIsApproved(true);
    }

    public List<Entry> getUnapprovedEntries() {
        return entryRepository.findByIsApproved(false);
    }

    public List<Celebrity> getCelebrities() {
        return celebrityRepository.findAll();
    }

    public Long createPlayerOrGetId(Player player) {
        Optional<Player> existingPlayer =
                playerRepository.findOneByEmailAddress(player.getEmailAddress());
        if (existingPlayer.isPresent()) {
            return existingPlayer.get().getPlayerId();
        }
        Player newPlayer = playerRepository.save(player);
        return newPlayer.getPlayerId();
    }

    public Long createEntry(Entry entry) {
        Entry savedEntry = entryRepository.save(entry);

        entry.getEntrySelections().forEach(entrySelection -> {
            entrySelection.setCelebrity(createOrGetCelebrityByName(entrySelection.getCelebrity().getCelebrityName()));
            entrySelection.setEntry(savedEntry);
            entrySelectionRepository.save(entrySelection);
        });
        return savedEntry.getEntryId();
    }

    private Celebrity createOrGetCelebrityByName(String name) {
        Optional<Celebrity> celebrity = celebrityRepository.findOneByCelebrityName(name);
        return celebrity.orElseGet(() -> celebrityRepository.save(new Celebrity(name)));
    }

    public Long saveCelebrities(List<Celebrity> celebrities) {
        celebrityRepository.saveAll(celebrities);
        // TODO: proper error code propagation
        return 200L;
    }

    public Long saveEntries(List<Entry> entries) {
        entryRepository.saveAll(entries);
        // TODO: proper error code propagation
        return 200L;
    }
}
