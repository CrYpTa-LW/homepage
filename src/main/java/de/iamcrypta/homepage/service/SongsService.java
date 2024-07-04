package de.iamcrypta.homepage.service;

import de.iamcrypta.homepage.dto.SongDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SongsService {

    /**
     * Gets all songs that got deleted in the playlist
     * @return A list of sooooosSongs. Not ordered in any way.
     */
    List<SongDTO> getAllDeletedSongs();

    /**
     * Gets all songs that got added to the playlist
     * @return A list of sooooosSongs. Not ordered in any way.
     */
    List<SongDTO> getAllAddedSongs();

    /**
     * Saves a list of songs in the temp database
     * @param s A list of sooooosSongs to be saved
     */
    void saveAllSooooosTemp(List<SongDTO> s);

    /**
     * Deletes all rows in temp database
     */
    void deleteAllSongsTemp();
}
