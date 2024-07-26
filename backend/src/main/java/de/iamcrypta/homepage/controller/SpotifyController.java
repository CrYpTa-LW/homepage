package de.iamcrypta.homepage.controller;

import de.iamcrypta.homepage.dto.SongChangeDTO;
import de.iamcrypta.homepage.mapper.SongMapper;
import de.iamcrypta.homepage.model.SongChange;
import de.iamcrypta.homepage.service.SongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/api/v1")
public class SpotifyController {

    private final SongsService songsService;

    private final SongMapper songMapper;

    @Autowired
    public SpotifyController(SongsService songsService, SongMapper songMapper){
        this.songsService = songsService;
        this.songMapper = songMapper;
    }

    @CrossOrigin(origins = {"https://sooooos.leon-wegener.de", "http://192.168.178.90:3001"})
    @GetMapping(path = "/getSongChange")
    public List<SongChangeDTO> getSongChange(){
        List<SongChange> songChanges = songsService.getAllSongChange();
        return songMapper.convertAllSongChangesToSongChangeDtos(songChanges);
    }
}
