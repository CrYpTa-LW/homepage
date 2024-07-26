package de.iamcrypta.homepage.controller;

<<<<<<< HEAD
import de.iamcrypta.homepage.model.PlaylistStat;
import de.iamcrypta.homepage.scheduledTask.ScheduledTask;
import de.iamcrypta.homepage.service.PlaylistStatService;
import de.iamcrypta.homepage.service.SpotifyService;
import de.iamcrypta.homepage.util.Util;
=======
import de.iamcrypta.homepage.dto.SongChangeDTO;
import de.iamcrypta.homepage.scheduledTask.ScheduledTask;
import de.iamcrypta.homepage.service.SongsService;
>>>>>>> develop
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import java.util.*;
=======
import java.util.List;
>>>>>>> develop

@RestController
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);

    private final ScheduledTask scheduledTask;
<<<<<<< HEAD
    private final SpotifyService spotifyService;
    private final Util util;
    private final PlaylistStatService playlistStatsService;

    @Autowired
    public TestController(ScheduledTask scheduledTask, SpotifyService spotifyService, Util util, PlaylistStatService playlistStatsService) {
        this.scheduledTask = scheduledTask;
        this.spotifyService = spotifyService;
        this.util = util;
        this.playlistStatsService = playlistStatsService;
=======
    private final SongsService songsService;

    @Autowired
    public TestController(ScheduledTask scheduledTask, SongsService songsService) {
        this.scheduledTask = scheduledTask;
        this.songsService = songsService;
>>>>>>> develop
    }

    @SuppressWarnings("SpellCheckingInspection")
    @GetMapping(path = "/test")
    public List<SongChangeDTO> test(){
        logger.info("GOGOGO");

<<<<<<< HEAD
        HashMap<String, Integer> value = new HashMap<>();
        value.put("leon", 1000);
        value.put("finn", 2000);

        PlaylistStat stat = new PlaylistStat(new Date(), value);
        List<PlaylistStat> stats = playlistStatsService.getAllPlaylistStats();

        return "";
=======
        return songsService.getAllSongChangeDto();
>>>>>>> develop
    }
}
