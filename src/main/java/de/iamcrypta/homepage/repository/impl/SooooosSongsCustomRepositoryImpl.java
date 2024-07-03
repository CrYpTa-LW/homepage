package de.iamcrypta.homepage.repository.impl;

import de.iamcrypta.homepage.model.SooooosSongs;
import de.iamcrypta.homepage.repository.SooooosSongsCustomRepository;

import java.util.List;

public class SooooosSongsCustomRepositoryImpl implements SooooosSongsCustomRepository {
    @Override
    public List<SooooosSongs> findSongsNotInTemp() {

        return List.of();
    }

    @Override
    public List<SooooosSongs> findTempSongsNotInSongs() {
        return List.of();
    }

    /*
    (   SELECT * FROM sooooos_songs ss
    EXCEPT
    SELECT * FROM sooooos_temp sst)
	UNION ALL
(   SELECT * FROM sooooos_temp sst2
    EXCEPT
    SELECT * FROM sooooos_songs ss2) 
     */
}
