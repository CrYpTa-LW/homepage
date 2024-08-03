package de.iamcrypta.homepage.repository;

import de.iamcrypta.homepage.dto.SongDTO;
import de.iamcrypta.homepage.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface SongsRepository extends JpaRepository<Song, Long> {

    /**
     * Searches for songs that are in songs(old)-table but not in temp(new)-table. --> Song got deleted
     *
     * @return A list of SongsEntity
     */
    @Query(nativeQuery = true)
    List<SongDTO> findSongsNotInTemp();

    /**
     * Searches for songs that are in temp(new)-table but in songs(old)-table. --> Song got added
     *
     * @return A list of SongsEntity
     */
    @Query(nativeQuery = true)
    List<SongDTO> findTempNotInSongs();

    /**
     * Deletes song entry where all columns match except the id(pk)
     *
     * @param addedBy            Added by
     * @param dateAdded          Date Added
     * @param isLocalTrack       isLocalTrack
     * @param durationMs         durationMs
     * @param songName           songName
     * @param spotifyExternalUrl spotifyExternalUrl
     * @param spotifySongId      spotifySongId
     */
    @Modifying
    @Query("delete from Song s where s.addedBy=:addedBy and s.dateAdded=:dateAdded and s.isLocalTrack=:isLocalTrack and s.durationMs=:durationMs and s.songName=:songName and s.spotifyExternalUrl=:spotifyExternalUrl and s.spotifySongId=:spotifySongId and s.artists=:artists")
    void deleteSongBy(@Param("addedBy") String addedBy,
                      @Param("dateAdded") OffsetDateTime dateAdded,
                      @Param("isLocalTrack") boolean isLocalTrack,
                      @Param("durationMs") int durationMs,
                      @Param("songName") String songName,
                      @Param("spotifyExternalUrl") String spotifyExternalUrl,
                      @Param("spotifySongId") String spotifySongId,
                      @Param("artists") String artists);
}
