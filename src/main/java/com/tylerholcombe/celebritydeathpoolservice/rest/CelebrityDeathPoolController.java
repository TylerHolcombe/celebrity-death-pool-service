package com.tylerholcombe.celebritydeathpoolservice.rest;

import com.tylerholcombe.celebritydeathpoolservice.model.Celebrity;
import com.tylerholcombe.celebritydeathpoolservice.model.Entry;
import com.tylerholcombe.celebritydeathpoolservice.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class CelebrityDeathPoolController {
    private static final Logger logger = Logger.getLogger(CelebrityDeathPoolController.class.getName());

    @Autowired
    private PlayerService playerService;

    @GetMapping("/entries/approved")
    public List<Entry> getApprovedEntries() {
        logger.info("Request received at: /entries/approved");
        return playerService.getApprovedEntries();
    }

    @GetMapping("/entries/unapproved")
    public List<Entry> getUnapprovedEntries() {
        logger.info("Request received at: /entries/unapproved");
        return playerService.getUnapprovedEntries();
    }

    @GetMapping("/celebrities")
    public List<Celebrity> getCelebrities() {
        logger.info("Request received at: /celebrities");
        return playerService.getCelebrities();
    }
}
