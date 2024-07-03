package de.iamcrypta.homepage.repository;

import de.iamcrypta.homepage.model.SooooosSongs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SooooosSongsRepository extends JpaRepository<SooooosSongs, Long> {

    /**
     * Searches for songs that are in songs(old)-table but not in temp(new)-table. --> Song got deleted
     * TODO: Create DTA so id doesnt have to be set to 0
     * @return A list of SooooosSongsEntity
     */
    @Query(value =
            """
            SELECT 0 as id, ss2.added_by,ss2.date_added, ss2.is_local_track, ss2.duration_ms, ss2.song_name, ss2.spotify_external_url, ss2.spotify_song_id FROM sooooos_songs ss2
            EXCEPT
            SELECT 0 as id, st.added_by,st.date_added, st.is_local_track, st.duration_ms, st.song_name, st.spotify_external_url, st.spotify_song_id FROM sooooos_temp st
            """,
            nativeQuery = true)
    List<SooooosSongs> findSongsNotInTemp();

    /**
     * Searches for songs that are in temp(new)-table but in songs(old)-table. --> Song got added
     * TODO: Create DTA so id doesnt have to be set to 0
     * @return A list of SooooosSongsEntity
     */
    @Query(value =
            """
            SELECT 0 as id, st.added_by,st.date_added, st.is_local_track, st.duration_ms, st.song_name, st.spotify_external_url, st.spotify_song_id FROM sooooos_temp st
            EXCEPT
            SELECT 0 as id, ss2.added_by,ss2.date_added, ss2.is_local_track, ss2.duration_ms, ss2.song_name, ss2.spotify_external_url, ss2.spotify_song_id FROM sooooos_songs ss2
            """,
            nativeQuery = true)
    List<SooooosSongs> findTempSongsNotInSongs();
}
