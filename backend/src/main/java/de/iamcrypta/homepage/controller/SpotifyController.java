package de.iamcrypta.homepage.controller;

import de.iamcrypta.homepage.dto.SongChangeDTO;
import de.iamcrypta.homepage.mapper.SongMapper;
import de.iamcrypta.homepage.model.SongChange;
import de.iamcrypta.homepage.repository.SongsChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/api/v1")
public class SpotifyController {

    private final SongsChangeRepository songsChangeRepository;

    private final SongMapper songMapper;

    @Autowired
    public SpotifyController(SongsChangeRepository songsChangeRepository, SongMapper songMapper){
        this.songMapper = songMapper;
        this.songsChangeRepository = songsChangeRepository;
    }

    @GetMapping(path = "/getSongChange")
    public List<SongChangeDTO> getSongChange(){
        List<SongChange> songChanges = songsChangeRepository.findAll();
        return songMapper.convertAllSongChangesToSongChangeDtos(songChanges);
    }
}
