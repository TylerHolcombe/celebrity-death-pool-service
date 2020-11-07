package com.tylerholcombe.celebritydeathpoolservice.rest;

import com.tylerholcombe.celebritydeathpoolservice.model.Celebrity;
import com.tylerholcombe.celebritydeathpoolservice.model.Entry;
import com.tylerholcombe.celebritydeathpoolservice.model.Player;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;

@RestController
public class CelebrityDeathPoolController {
    private static final Logger logger = Logger.getLogger(CelebrityDeathPoolController.class.getName());

    @GetMapping("/entries/approved")
    public List<Entry> getApprovedEntries() {
        logger.info("Request received at: /entries/approved");
        return getMockEntries().stream().filter(Entry::isApproved).collect(toList());
    }

    @GetMapping("/entries/unapproved")
    public List<Entry> getUnapprovedEntries() {
        logger.info("Request received at: /entries/unapproved");
        return getMockEntries().stream().filter(not(Entry::isApproved)).collect(toList());
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
