package de.iamcrypta.homepage.service;

import de.iamcrypta.homepage.model.SooooosSong;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SooooosSongsService {

    /**
     * Gets all songs that got deleted in the playlist
     * @return A list of sooooosSongs. Not ordered in any way.
     */
    List<SooooosSong> getAllDeletedSongs();

    /**
     * Gets all songs that got added to the playlist
     * @return A list of sooooosSongs. Not ordered in any way.
     */
    List<SooooosSong> getAllAddedSongs();

    /**
     * Saves a list of songs in the temp database
     * @param s A list of sooooosSongs to be saved
     */
    void saveAllSooooosTemp(List<SooooosSong> s);

    /**
     * Deletes all rows in temp database
     */
    void deleteAllSongsTemp();
}
