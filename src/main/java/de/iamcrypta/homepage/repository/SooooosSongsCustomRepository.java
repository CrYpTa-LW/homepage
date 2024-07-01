package de.iamcrypta.homepage.repository;

import de.iamcrypta.homepage.model.SooooosSongs;

import java.util.List;

public interface SooooosSongsCustomRepository {

    List<SooooosSongs> findSongsNotInTemp();

    List<SooooosSongs> findTempSongsNotInSongs()
}
