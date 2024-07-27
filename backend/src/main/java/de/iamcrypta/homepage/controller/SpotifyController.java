package de.iamcrypta.homepage.controller;

import de.iamcrypta.homepage.dto.SongChangeDTO;
import de.iamcrypta.homepage.mapper.SongMapper;
import de.iamcrypta.homepage.model.SongChange;
import de.iamcrypta.homepage.service.SongsService;
import de.iamcrypta.homepage.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping(path = "/api/v1")
public class SpotifyController {

    private final SongsService songsService;
    private final SpotifyService spotifyService;
    private final SongMapper songMapper;

    @Autowired
    public SpotifyController(SongsService songsService, SpotifyService spotifyService, SongMapper songMapper){
        this.songsService = songsService;
        this.spotifyService = spotifyService;
        this.songMapper = songMapper;
    }

    @CrossOrigin(origins = {"https://sooooos.leon-wegener.de", "http://localhost:3001"})
    @GetMapping(path = "/getSongChange")
    public List<SongChangeDTO> getSongChange(){
        List<SongChange> songChanges = songsService.getAllSongChange();
        return songMapper.convertAllSongChangesToSongChangeDtos(songChanges);
    }

    @CrossOrigin(origins = {"https://sooooos.leon-wegener.de", "http://localhost:3001"})
    @GetMapping(path = "/getPlaylistStatsForDuration")
    public Map<String, Integer> getPlaylistStatsForDuration(){
        return spotifyService.getPlaylistStatsForDuration();
    }

}
