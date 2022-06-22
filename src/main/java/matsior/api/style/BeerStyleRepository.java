package matsior.api.style;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeerStyleRepository extends CrudRepository<BeerStyle, Long> {
    List<BeerStyle> findAll();
}
