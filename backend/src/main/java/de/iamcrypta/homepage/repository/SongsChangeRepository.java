package de.iamcrypta.homepage.repository;

import de.iamcrypta.homepage.model.SongChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongsChangeRepository extends JpaRepository<SongChange, Long> {
}
