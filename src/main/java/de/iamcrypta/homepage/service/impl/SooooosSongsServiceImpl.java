package de.iamcrypta.homepage.service.impl;

import de.iamcrypta.homepage.dto.SooooosSongDTO;
import de.iamcrypta.homepage.model.SooooosSong;
import de.iamcrypta.homepage.repository.SooooosSongsRepository;
import de.iamcrypta.homepage.repository.SooooosSongsTempRepository;
import de.iamcrypta.homepage.service.SooooosSongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SooooosSongsServiceImpl implements SooooosSongsService {

    private final SooooosSongsRepository sooooosSongsRepository;
    private final SooooosSongsTempRepository sooooosSongsTempRepository;

    @Autowired
    public SooooosSongsServiceImpl(SooooosSongsRepository sooooosSongsRepository, SooooosSongsTempRepository sooooosSongsTempRepository) {
        this.sooooosSongsRepository = sooooosSongsRepository;
        this.sooooosSongsTempRepository = sooooosSongsTempRepository;
    }

    @Override
    public List<SooooosSongDTO> getAllDeletedSongs() {
        List<SooooosSong> sooooosSongs = sooooosSongsRepository.findSongsNotInTemp();
        return convertAllSooooosSongToSooooosSongDto(sooooosSongs);
    }

    @Override
    public List<SooooosSongDTO> getAllAddedSongs() {
        List<SooooosSong> sooooosSongs = sooooosSongsRepository.findTempSongsNotInSongs();
        return convertAllSooooosSongToSooooosSongDto(sooooosSongs);
    }

    private SooooosSongDTO convertSooooosSongToSooooosSongDto(SooooosSong song){
        return new SooooosSongDTO(song.getAddedBy(),
                                  song.getDateAdded(),
                                  song.isLocalTrack(),
                                  song.getDurationMs(),
                                  song.getSongName(),
                                  song.getSpotifyExternalUrl(),
                                  song.getSpotifySongId());
    }

    private List<SooooosSongDTO> convertAllSooooosSongToSooooosSongDto(List<SooooosSong> songs){
        List<SooooosSongDTO> dtos = new ArrayList<>();
        for(SooooosSong song: songs){
            dtos.add(convertSooooosSongToSooooosSongDto(song));
        }
        return dtos;
    }

    @Override
    public void saveAllSooooosTemp(List<SooooosSongDTO> s) {

    }

    @Override
    public void deleteAllSongsTemp() {
        sooooosSongsRepository.deleteAll();
    }
}
