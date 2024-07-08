package de.iamcrypta.homepage.repository;

import de.iamcrypta.homepage.model.SongTemp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongsTempRepository extends JpaRepository<SongTemp, Long> {
}
