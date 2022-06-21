package matsior.api.repository;

import matsior.api.model.Beer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeerRepository extends CrudRepository<Beer, Long> {
    List<Beer> findAll();
}
