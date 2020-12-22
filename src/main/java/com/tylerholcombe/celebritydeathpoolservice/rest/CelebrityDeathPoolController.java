package com.tylerholcombe.celebritydeathpoolservice.rest;

import com.tylerholcombe.celebritydeathpoolservice.model.Celebrity;
import com.tylerholcombe.celebritydeathpoolservice.model.Entry;
import com.tylerholcombe.celebritydeathpoolservice.model.Player;
import com.tylerholcombe.celebritydeathpoolservice.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

import static com.tylerholcombe.celebritydeathpoolservice.validator.PlayerValidator.validateNewPlayerDetails;

@RestController
public class CelebrityDeathPoolController {
    private static final Logger logger = Logger.getLogger(CelebrityDeathPoolController.class.getName());

    @Autowired
    private PlayerService playerService;

    @GetMapping("/entries/approved")
    public List<Entry> getApprovedEntries() {
        logger.info("GET request received at: /entries/approved");
        return playerService.getApprovedEntries();
    }

    @GetMapping("/entries/unapproved")
    public List<Entry> getUnapprovedEntries() {
        logger.info("GET request received at: /entries/unapproved");
        return playerService.getUnapprovedEntries();
    }

    @PostMapping("/entries")
    public Long createEntry(@RequestBody Entry entry) {
        logger.info("POST request received at: /entries");
        return playerService.createEntry(entry);
    }

    @GetMapping("/celebrities")
    public List<Celebrity> getCelebrities() {
        logger.info("GET request received at: /celebrities");
        return playerService.getCelebrities();
    }

    @PostMapping("/players")
    public Long createPlayer(@RequestBody Player player) {
        logger.info("POST request received at: /players");
        validateNewPlayerDetails(player);
        return playerService.createPlayerOrGetId(player);
    }
}
