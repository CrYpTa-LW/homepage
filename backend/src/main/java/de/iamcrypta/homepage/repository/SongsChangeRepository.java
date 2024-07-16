package de.iamcrypta.homepage.repository;

import de.iamcrypta.homepage.model.SongChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongsChangeRepository extends JpaRepository<SongChange, Long> {

    List<SongChange> findAllByOrderByChangeOccurredAtDesc();
}
