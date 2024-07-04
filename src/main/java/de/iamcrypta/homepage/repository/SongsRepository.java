package de.iamcrypta.homepage.repository;

import de.iamcrypta.homepage.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SongsRepository extends JpaRepository<Song, Long> {

    /**
     * Searches for songs that are in songs(old)-table but not in temp(new)-table. --> Song got deleted
     * TODO: Create DTA so id doesnt have to be set to 0
     * @return A list of SongsEntity
     */
    @Query(value =
            """
            SELECT 0 as id, s.added_by,s.date_added, s.is_local_track, s.duration_ms, s.song_name, s.spotify_external_url, s.spotify_song_id FROM songs s
            EXCEPT
            SELECT 0 as id, st.added_by,st.date_added, st.is_local_track, st.duration_ms, st.song_name, st.spotify_external_url, st.spotify_song_id FROM songs_temp st
            """,
            nativeQuery = true)
    List<Song> findSongsNotInTemp();

    /**
     * Searches for songs that are in temp(new)-table but in songs(old)-table. --> Song got added
     * TODO: Create DTA so id doesnt have to be set to 0
     * @return A list of SongsEntity
     */
    @Query(value =
            """
            SELECT 0 as id, st.added_by,st.date_added, st.is_local_track, st.duration_ms, st.song_name, st.spotify_external_url, st.spotify_song_id FROM songs_temp st
            EXCEPT
            SELECT 0 as id, s.added_by,s.date_added, s.is_local_track, s.duration_ms, s.song_name, s.spotify_external_url, s.spotify_song_id FROM songs s
            """,
            nativeQuery = true)
    List<Song> findTempNotInSongs();
}
