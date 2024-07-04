package de.iamcrypta.homepage.repository;

import de.iamcrypta.homepage.model.SongTemp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongsTempRepository extends JpaRepository<SongTemp, Long> {
}
