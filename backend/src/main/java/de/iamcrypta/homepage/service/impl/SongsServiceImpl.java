package de.iamcrypta.homepage.service.impl;

import de.iamcrypta.homepage.dto.SongDTO;
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

    private final SongsRepository songsRepository;
    private final SongsTempRepository songsTempRepository;
    private final SongsChangeRepository songsChangeRepository;

    @Autowired
    public SongsServiceImpl(SongsRepository songsRepository, SongsTempRepository songsTempRepository, SongsChangeRepository songsChangeRepository) {
        this.songsRepository = songsRepository;
        this.songsTempRepository = songsTempRepository;
        this.songsChangeRepository = songsChangeRepository;
    }

    @Override
    @Transactional
    public List<SongDTO> getAllDeletedSongs() {
        return songsRepository.findSongsNotInTemp();
    }

    @Override
    @Transactional
    public List<SongDTO> getAllAddedSongs() {
        return songsRepository.findTempNotInSongs();
    }

    @Override
    @Transactional
    public void saveAllSongs(List<Song> songs) {
        songsRepository.saveAllAndFlush(songs);
    }

    @Override
    @Transactional
    public void deleteListOfSongs(List<Song> songs) {
        for(Song s: songs){
            songsRepository.deleteSongBy(s.getAddedBy(), s.getDateAdded(), s.isLocalTrack(), s.getDurationMs(), s.getSongName(), s.getSpotifyExternalUrl(), s.getSpotifySongId());
        }
    }

    @Override
    @Transactional
    public void saveAllTemp(List<SongTemp> temp) {
        songsTempRepository.saveAllAndFlush(temp);
    }

    @Override
    @Transactional
    public void deleteAllSongsTemp() {
        songsTempRepository.deleteAllInBatch();
    }

    @Override
    @Transactional
    public void saveAllSongsChange(List<SongChange> changes) {
        songsChangeRepository.saveAllAndFlush(changes);
    }

    @Override
    public List<SongChange> getAllSongChange() {
        return songsChangeRepository.findAllByOrderByChangeOccurredAtDesc();
    }
}
