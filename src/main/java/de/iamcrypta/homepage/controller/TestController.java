package de.iamcrypta.homepage.controller;

import de.iamcrypta.homepage.dto.SooooosSongDTO;
import de.iamcrypta.homepage.service.SooooosSongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    SooooosSongsService sooooosSongsService;

    @GetMapping(path = "/test")
    public String test(){
        List<SooooosSongDTO> s = sooooosSongsService.getAllDeletedSongs();
        return s.toString();
    }
}
