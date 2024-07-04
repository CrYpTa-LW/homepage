package de.iamcrypta.homepage.controller;

import de.iamcrypta.homepage.dto.SongChangeDTO;
import de.iamcrypta.homepage.mapper.SongMapper;
import de.iamcrypta.homepage.model.SongChange;
import de.iamcrypta.homepage.repository.SongsChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/api")
public class SpotifyController {

    @Autowired
    SongsChangeRepository songsChangeRepository;

    @Autowired
    SongMapper songMapper;

    @GetMapping(path = "/getSongChange")
    public List<SongChangeDTO> getSongChange(){
        List<SongChange> songChanges = songsChangeRepository.findAll();
        return songMapper.convertAllSongChangesToSongChangeDtos(songChanges);
    }
}
