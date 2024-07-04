package de.iamcrypta.homepage.service.impl;

import de.iamcrypta.homepage.dto.SooooosSongDTO;
import de.iamcrypta.homepage.mapper.SooooosSongMapper;
import de.iamcrypta.homepage.model.SooooosSong;
import de.iamcrypta.homepage.model.SooooosTemp;
import de.iamcrypta.homepage.repository.SooooosSongsRepository;
import de.iamcrypta.homepage.repository.SooooosSongsTempRepository;
import de.iamcrypta.homepage.service.SooooosSongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SooooosSongsServiceImpl implements SooooosSongsService {

    private final SooooosSongMapper sooooosSongMapper;
    private final SooooosSongsRepository sooooosSongsRepository;
    private final SooooosSongsTempRepository sooooosSongsTempRepository;

    @Autowired
    public SooooosSongsServiceImpl(SooooosSongMapper sooooosSongMapper, SooooosSongsRepository sooooosSongsRepository, SooooosSongsTempRepository sooooosSongsTempRepository) {
        this.sooooosSongMapper = sooooosSongMapper;
        this.sooooosSongsRepository = sooooosSongsRepository;
        this.sooooosSongsTempRepository = sooooosSongsTempRepository;
    }

    @Override
    public List<SooooosSongDTO> getAllDeletedSongs() {
        List<SooooosSong> sooooosSongs = sooooosSongsRepository.findSongsNotInTemp();
        return sooooosSongMapper.convertAllSooooosSongToSooooosSongDto(sooooosSongs);
    }

    @Override
    public List<SooooosSongDTO> getAllAddedSongs() {
        List<SooooosSong> sooooosSongs = sooooosSongsRepository.findTempSongsNotInSongs();
        return sooooosSongMapper.convertAllSooooosSongToSooooosSongDto(sooooosSongs);
    }

    @Override
    public void saveAllSooooosTemp(List<SooooosSongDTO> dtos) {
        List<SooooosTemp> s = sooooosSongMapper.convertAllSooooosSongDtoToSooooosTemp(dtos);
        sooooosSongsTempRepository.saveAllAndFlush(s);
    }

    @Override
    public void deleteAllSongsTemp() {
        sooooosSongsRepository.deleteAll();
    }
}
