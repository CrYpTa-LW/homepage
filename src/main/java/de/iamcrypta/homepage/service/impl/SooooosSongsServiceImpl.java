package de.iamcrypta.homepage.service.impl;

import de.iamcrypta.homepage.model.SooooosSong;
import de.iamcrypta.homepage.repository.SooooosSongsRepository;
import de.iamcrypta.homepage.repository.SooooosSongsTempRepository;
import de.iamcrypta.homepage.service.SooooosSongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<SooooosSong> getAllDeletedSongs() {
        return sooooosSongsRepository.findSongsNotInTemp();
    }

    @Override
    public List<SooooosSong> getAllAddedSongs() {
        return sooooosSongsRepository.findTempSongsNotInSongs();
    }

    @Override
    public void saveAllSooooosTemp(List<SooooosSong> s) {

    }

    @Override
    public void deleteAllSongsTemp() {
        sooooosSongsRepository.deleteAll();
    }
}
