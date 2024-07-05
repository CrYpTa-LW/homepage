package de.iamcrypta.homepage.service.impl;

import de.iamcrypta.homepage.dto.SongDTO;
import de.iamcrypta.homepage.mapper.SongMapper;
import de.iamcrypta.homepage.model.Song;
import de.iamcrypta.homepage.model.SongChange;
import de.iamcrypta.homepage.model.SongTemp;
import de.iamcrypta.homepage.repository.SongsChangeRepository;
import de.iamcrypta.homepage.repository.SongsRepository;
import de.iamcrypta.homepage.repository.SongsTempRepository;
import de.iamcrypta.homepage.service.SongsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongsServiceImpl implements SongsService {

    private final SongMapper songMapper;
    private final SongsRepository songsRepository;
    private final SongsTempRepository songsTempRepository;
    private final SongsChangeRepository songsChangeRepository;

    @Autowired
    public SongsServiceImpl(SongMapper songMapper, SongsRepository songsRepository, SongsTempRepository songsTempRepository, SongsChangeRepository songsChangeRepository) {
        this.songMapper = songMapper;
        this.songsRepository = songsRepository;
        this.songsTempRepository = songsTempRepository;
        this.songsChangeRepository = songsChangeRepository;
    }

    @Override
    public List<SongDTO> getAllDeletedSongs() {
        return songsRepository.findSongsNotInTemp();
    }

    @Override
    public List<SongDTO> getAllAddedSongs() {
        return songsRepository.findTempNotInSongs();
    }

    @Override
    @Transactional
    public void saveAllSongs(List<Song> songs) {
        songsRepository.saveAll(songs);
        songsRepository.flush();
    }

    @Override
    public void deleteListOfSongs(List<Song> songs) {
        if(songs != null){
            songsRepository.deleteAllInBatch(songs);
        }
    }

    @Override
    public void saveAllTemp(List<SongTemp> temp) {
        songsTempRepository.saveAllAndFlush(temp);
    }

    @Override
    public void deleteAllSongsTemp() {
        songsTempRepository.deleteAllInBatch();
    }

    @Override
    public void saveAllSongsChange(List<SongChange> changes) {
        songsChangeRepository.saveAllAndFlush(changes);
    }


}
