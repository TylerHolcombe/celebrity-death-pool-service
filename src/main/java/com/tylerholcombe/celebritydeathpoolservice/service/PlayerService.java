package com.tylerholcombe.celebritydeathpoolservice.service;

import com.tylerholcombe.celebritydeathpoolservice.model.Celebrity;
import com.tylerholcombe.celebritydeathpoolservice.model.Entry;
import com.tylerholcombe.celebritydeathpoolservice.model.Player;
import com.tylerholcombe.celebritydeathpoolservice.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;

@Service
public class PlayerService {
    @Autowired
    private EntryRepository entryRepository;

    public List<Entry> getApprovedEntries() {
        return entryRepository.findByIsApproved(true).stream().map(Entry::syncSelections).collect(toList());
    }

    public List<Entry> getUnapprovedEntries() {
        return entryRepository.findByIsApproved(false).stream().map(Entry::syncSelections).collect(toList());
    }

    public List<Celebrity> getCelebrities() {
        return getMockCelebrities();
    }

    // TODO: Remove mock data
    private static List<Player> getMockPlayers() {
        Player player1 = new Player();
        player1.setPlayerId(1);
        player1.setFirstName("Player");
        player1.setLastName("1");
        player1.setEmailAddress("player1email@email.com");
        player1.setEntries(Set.of(getMockEntry(1, true, true)));

        Player player2 = new Player();
        player2.setPlayerId(2);
        player2.setFirstName("Player");
        player2.setLastName("2");
        player2.setEmailAddress("player2email@email.com");
        player2.setEntries(Set.of(getMockEntry(2, true, false), getMockEntry(3, false, false)));

        Player player3 = new Player();
        player3.setPlayerId(3);
        player3.setFirstName("Player");
        player3.setLastName("3");
        player3.setEmailAddress("player3email@email.com");
        player3.setEntries(Set.of(getMockEntry(4, true, false), getMockEntry(5, true, true)));

        return List.of(player1, player2, player3);
    }

    // TODO: Remove mock data
    private static List<Entry> getMockEntries() {
        Player player1 = new Player();
        player1.setPlayerId(1);
        player1.setFirstName("Player");
        player1.setLastName("1");
        player1.setEmailAddress("player1email@email.com");

        Entry entry1 = getMockEntry(1, true, true);
        entry1.setPlayer(player1);

        Player player2 = new Player();
        player2.setPlayerId(2);
        player2.setFirstName("Player");
        player2.setLastName("2");
        player2.setEmailAddress("player2email@email.com");

        Entry entry2 = getMockEntry(2, true, false);
        entry2.setPlayer(player2);
        Entry entry3 = getMockEntry(3, false, false);
        entry3.setPlayer(player2);

        Player player3 = new Player();
        player3.setPlayerId(3);
        player3.setFirstName("Player");
        player3.setLastName("3");
        player3.setEmailAddress("player3email@email.com");

        Entry entry4 = getMockEntry(4, true, false);
        entry4.setPlayer(player3);
        Entry entry5 = getMockEntry(5, true, true);
        entry5.setPlayer(player3);

        return List.of(entry1, entry2, entry3, entry4, entry5);
    }

    // TODO: Remove mock data
    private static Entry getMockEntry(long entryId, boolean isApproved, boolean isPaid) {
        Entry entry = new Entry();
        entry.setEntryId(entryId);
        entry.setApproved(isApproved);
        entry.setPaid(isPaid);
        entry.setSelections(getMockCelebrities());

        return entry;
    }

    // TODO: Remove mock data
    private static List<Celebrity> getMockCelebrities() {
        Celebrity celebrity1 = new Celebrity();
        celebrity1.setCelebrityId(1);
        celebrity1.setCelebrityName("Living Standard");
        celebrity1.setDead(false);
        celebrity1.setWildcard(false);

        Celebrity celebrity2 = new Celebrity();
        celebrity2.setCelebrityId(2);
        celebrity2.setCelebrityName("Living Wildcard");
        celebrity2.setDead(false);
        celebrity2.setWildcard(true);

        Celebrity celebrity3 = new Celebrity();
        celebrity3.setCelebrityId(3);
        celebrity3.setCelebrityName("Dead Standard");
        celebrity3.setDead(true);
        celebrity3.setWildcard(false);

        Celebrity celebrity4 = new Celebrity();
        celebrity4.setCelebrityId(4);
        celebrity4.setCelebrityName("Dead Wildcard");
        celebrity4.setDead(true);
        celebrity4.setWildcard(true);

        return List.of(celebrity1, celebrity2, celebrity3, celebrity4);
    }
}
