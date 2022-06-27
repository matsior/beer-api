package matsior.api.beer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeerRepository extends CrudRepository<Beer, Long> {
    List<Beer> findAll();
    List<Beer> findAllByCountryIgnoreCase(String country);
    List<Beer> findAllByAlcoholGreaterThanEqual(double alcohol);
    List<Beer> findAllByCountryContainsIgnoreCaseAndAlcoholGreaterThanEqual(String country, double alcohol);
}