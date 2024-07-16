package de.iamcrypta.homepage.controller;

import de.iamcrypta.homepage.dto.SongChangeDTO;
import de.iamcrypta.homepage.scheduledTask.ScheduledTask;
import de.iamcrypta.homepage.service.SongsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);

    private final ScheduledTask scheduledTask;
    private final SongsService songsService;

    @Autowired
    public TestController(ScheduledTask scheduledTask, SongsService songsService) {
        this.scheduledTask = scheduledTask;
        this.songsService = songsService;
    }

    @SuppressWarnings("SpellCheckingInspection")
    @GetMapping(path = "/test")
    public List<SongChangeDTO> test(){
        logger.info("GOGOGO");

        return songsService.getAllSongChangeDto();
    }
}
