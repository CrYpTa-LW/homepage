package de.iamcrypta.homepage.controller;

import de.iamcrypta.homepage.dto.SongChangeDTO;
import de.iamcrypta.homepage.service.SongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/api/v1")
public class SpotifyController {

    private final SongsService songsService;

    @Autowired
    public SpotifyController(SongsService songsService){
        this.songsService = songsService;
    }

    @CrossOrigin(origins = {"https://sooooos.leon-wegener.de", "http://localhost"})
    @GetMapping(path = "/getSongChange")
    public List<SongChangeDTO> getSongChange(){
        return songsService.getAllSongChangeDto();
    }
}
