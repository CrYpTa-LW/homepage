package de.iamcrypta.homepage.controller;

import de.iamcrypta.homepage.dto.SongDTO;
import de.iamcrypta.homepage.service.SongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    SongsService songsService;

    @GetMapping(path = "/test")
    public String test(){
        List<SongDTO> s = songsService.getAllDeletedSongs();
        return s.toString();
    }
}
