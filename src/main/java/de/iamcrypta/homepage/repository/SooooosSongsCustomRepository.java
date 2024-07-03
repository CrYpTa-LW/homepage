package de.iamcrypta.homepage.repository;

import de.iamcrypta.homepage.model.SooooosSongs;

import java.util.List;

public interface SooooosSongsCustomRepository {

    /**
     * Searches for songs that are in songs(old)-table but in temp(new)-table. --> Song got deleted
     * @return A list of SooooosSongsEntity
     */
    List<SooooosSongs> findSongsNotInTemp();

    /**
     * Searches for songs that are in temp(new)-table but in songs(old)-table. --> Song got added
     * @return
     */
    List<SooooosSongs> findTempSongsNotInSongs();
}
