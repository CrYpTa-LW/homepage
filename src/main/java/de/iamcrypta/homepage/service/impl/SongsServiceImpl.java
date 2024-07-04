package de.iamcrypta.homepage.service.impl;

import de.iamcrypta.homepage.dto.SongDTO;
import de.iamcrypta.homepage.mapper.SongMapper;
import de.iamcrypta.homepage.model.Song;
import de.iamcrypta.homepage.model.SongTemp;
import de.iamcrypta.homepage.repository.SongsRepository;
import de.iamcrypta.homepage.repository.SongsTempRepository;
import de.iamcrypta.homepage.service.SongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongsServiceImpl implements SongsService {

    private final SongMapper songMapper;
    private final SongsRepository songsRepository;
    private final SongsTempRepository songsTempRepository;

    @Autowired
    public SongsServiceImpl(SongMapper songMapper, SongsRepository songsRepository, SongsTempRepository songsTempRepository) {
        this.songMapper = songMapper;
        this.songsRepository = songsRepository;
        this.songsTempRepository = songsTempRepository;
    }

    @Override
    public List<SongDTO> getAllDeletedSongs() {
        List<Song> songs = songsRepository.findSongsNotInTemp();
        return songMapper.convertAllSongsToSongDtos(songs);
    }

    @Override
    public List<SongDTO> getAllAddedSongs() {
        List<Song> songs = songsRepository.findTempNotInSongs();
        return songMapper.convertAllSongsToSongDtos(songs);
    }

    @Override
    public void saveAllSooooosTemp(List<SongDTO> dtos) {
        List<SongTemp> s = songMapper.convertAllSongDtosToSongTemp(dtos);
        songsTempRepository.saveAllAndFlush(s);
    }

    @Override
    public void deleteAllSongsTemp() {
        songsRepository.deleteAll();
    }
}
