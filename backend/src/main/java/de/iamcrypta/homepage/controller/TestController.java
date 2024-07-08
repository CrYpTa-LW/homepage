package de.iamcrypta.homepage.controller;

import de.iamcrypta.homepage.scheduledTask.ScheduledTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);

    private final ScheduledTask scheduledTask;

    @Autowired
    public TestController(ScheduledTask scheduledTask) {
        this.scheduledTask = scheduledTask;
    }

    @SuppressWarnings("SpellCheckingInspection")
    @GetMapping(path = "/test")
    public String test(){
        logger.info("GOGOGO");

        scheduledTask.checkForPlaylistUpdates();
        return "Success :) Maybe??";
    }
}
