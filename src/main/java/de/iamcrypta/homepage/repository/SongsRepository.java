package de.iamcrypta.homepage.repository;

import de.iamcrypta.homepage.dto.SongDTO;
import de.iamcrypta.homepage.model.Song;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongsRepository extends JpaRepository<Song, Long> {

    /**
     * Searches for songs that are in songs(old)-table but not in temp(new)-table. --> Song got deleted
     * TODO: Create DTA so id doesnt have to be set to 0
     * @return A list of SongsEntity
     */
    @Query(nativeQuery = true)
    List<SongDTO> findSongsNotInTemp();

    /**
     * Searches for songs that are in temp(new)-table but in songs(old)-table. --> Song got added
     * TODO: Create DTA so id doesnt have to be set to 0
     * @return A list of SongsEntity
     */
    @Query(nativeQuery = true)
    List<SongDTO> findTempNotInSongs();
}
