package de.iamcrypta.homepage.repository;

import de.iamcrypta.homepage.model.SooooosSongs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SooooosSongsRepository extends JpaRepository<SooooosSongs, Long>, SooooosSongsCustomRepository {

}
