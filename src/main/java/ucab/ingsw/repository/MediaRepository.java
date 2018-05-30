package ucab.ingsw.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ucab.ingsw.model.Media;

import java.util.Optional;

@Repository("MediaRepository")

public interface MediaRepository extends CrudRepository<Media, Long>{

    Optional<Media> findById(Long id);
}
