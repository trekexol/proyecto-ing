package ucab.ingsw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ucab.ingsw.model.Url;

@Repository("UrlRepository")

public interface UrlRepository extends CrudRepository<Url, Long>{



}
