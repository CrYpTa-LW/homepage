package de.iamcrypta.homepage.controller;

import de.iamcrypta.homepage.dto.SongDTO;
import de.iamcrypta.homepage.scheduledTask.ScheduledTask;
import de.iamcrypta.homepage.service.SongsService;
import de.iamcrypta.homepage.service.SpotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    SongsService songsService;

    @Autowired
    ScheduledTask scheduledTask;

    @Autowired
    SpotifyService spotifyService;

    @GetMapping(path = "/test")
    public String test(){
        logger.info("GOGOGO");
        scheduledTask.checkForPlaylistUpdates();
        return "Success :) Maybe??";
    }
}
