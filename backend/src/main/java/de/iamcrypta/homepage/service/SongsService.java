package de.iamcrypta.homepage.service;

import de.iamcrypta.homepage.dto.SongDTO;
import de.iamcrypta.homepage.model.Song;
import de.iamcrypta.homepage.model.SongChange;
import de.iamcrypta.homepage.model.SongTemp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SongsService {

    /**
     * Gets all songs that got deleted in the playlist
     * @return A list of Songs. Not ordered in any way.
     */
    List<SongDTO> getAllDeletedSongs();

    /**
     * Gets all songs that got added to the playlist
     * @return A list of Songs. Not ordered in any way.
     */
    List<SongDTO> getAllAddedSongs();

    /**
     * Saves a list of songs in database
     * @param songs A list of songs to save in db
     */
    void saveAllSongs(List<Song> songs);

    /**
     * Deletes a list of songs from the song db.
     * IT WILL NOT CHECK THE PRIMARY KEY
     * @param songs List of songs to be deleted
     */
    void deleteListOfSongs(List<Song> songs);

    /**
     * Saves a list of temp_songs in the temp database
     * @param temp A list of Temp_Songs to be saved
     */
    void saveAllTemp(List<SongTemp> temp);

    /**
     * Deletes all rows in temp database
     */
    void deleteAllSongsTemp();

    /**
     * Saves a list of song changes into the song_changes database
     */
    void saveAllSongsChange(List<SongChange> changes);

    /**
     * Gets all song_change entries
     * @return a list of songchanges
     */
    List<SongChange> getAllSongChange();
}
