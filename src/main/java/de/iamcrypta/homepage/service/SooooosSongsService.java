package de.iamcrypta.homepage.service;

import de.iamcrypta.homepage.model.SooooosSongs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SooooosSongsService {

    /**
     * Gets all songs that got deleted in the playlist
     * @return A list of sooooosSongs. Not ordered in any way.
     */
    List<SooooosSongs> getAllDeletedSongs();

    /**
     * Gets all songs that got added to the playlist
     * @return A list of sooooosSongs. Not ordered in any way.
     */
    List<SooooosSongs> getAllAddedSongs();
}
