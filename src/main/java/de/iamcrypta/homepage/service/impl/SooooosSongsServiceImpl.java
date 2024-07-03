package de.iamcrypta.homepage.service.impl;

import de.iamcrypta.homepage.model.SooooosSongs;
import de.iamcrypta.homepage.repository.SooooosSongsRepository;
import de.iamcrypta.homepage.service.SooooosSongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SooooosSongsServiceImpl implements SooooosSongsService {

    private final SooooosSongsRepository sooooosSongsRepository;

    @Autowired
    public SooooosSongsServiceImpl(SooooosSongsRepository sooooosSongsRepository) {
        this.sooooosSongsRepository = sooooosSongsRepository;
    }

    @Override
    public List<SooooosSongs> getAllDeletedSongs() {
        return sooooosSongsRepository.findSongsNotInTemp();
    }

    @Override
    public List<SooooosSongs> getAllAddedSongs() {
        return sooooosSongsRepository.findTempSongsNotInSongs();
    }
}
