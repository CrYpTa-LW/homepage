package de.iamcrypta.homepage.controller;

import de.iamcrypta.homepage.model.PlaylistStat;
import de.iamcrypta.homepage.scheduledTask.ScheduledTask;
import de.iamcrypta.homepage.service.PlaylistStatService;
import de.iamcrypta.homepage.service.SpotifyService;
import de.iamcrypta.homepage.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);

    private final ScheduledTask scheduledTask;
    private final SpotifyService spotifyService;
    private final Util util;
    private final PlaylistStatService playlistStatsService;

    @Autowired
    public TestController(ScheduledTask scheduledTask, SpotifyService spotifyService, Util util, PlaylistStatService playlistStatsService) {
        this.scheduledTask = scheduledTask;
        this.spotifyService = spotifyService;
        this.util = util;
        this.playlistStatsService = playlistStatsService;
    }

    @SuppressWarnings("SpellCheckingInspection")
    @GetMapping(path = "/test")
    public String test(){
        logger.info("GOGOGO");

        HashMap<String, Integer> value = new HashMap<>();
        value.put("leon", 1000);
        value.put("finn", 2000);

        PlaylistStat stat = new PlaylistStat(new Date(), value);
        List<PlaylistStat> stats = playlistStatsService.getAllPlaylistStats();

        return "";
    }
}
