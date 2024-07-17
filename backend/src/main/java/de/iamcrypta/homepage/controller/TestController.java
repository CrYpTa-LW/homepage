package de.iamcrypta.homepage.controller;

import de.iamcrypta.homepage.scheduledTask.ScheduledTask;
import de.iamcrypta.homepage.service.SpotifyService;
import de.iamcrypta.homepage.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);

    private final ScheduledTask scheduledTask;
    private final SpotifyService spotifyService;
    private final Util util;

    @Autowired
    public TestController(ScheduledTask scheduledTask, SpotifyService spotifyService, Util util) {
        this.scheduledTask = scheduledTask;
        this.spotifyService = spotifyService;
        this.util = util;
    }

    @SuppressWarnings("SpellCheckingInspection")
    @GetMapping(path = "/test")
    public String test(){
        logger.info("GOGOGO");
        Map<String, Integer> map = spotifyService.getPlaylistStatsForDuration("4R9hr1Fw2vM5hCduEKerOw", Util.getAllPlaylistUsers());

        List<String> data = new ArrayList<>();

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            data.add(entry.getKey() + ": " + entry.getValue() / 3600000 + "Std. " + entry.getValue() /60000 % 60 + "Min.");
        }

        return data.toString();
    }
}
