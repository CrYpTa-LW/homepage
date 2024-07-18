package de.iamcrypta.homepage.repository;

import de.iamcrypta.homepage.model.PlaylistStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistStatsRepository extends JpaRepository<PlaylistStat, Long> {
}
