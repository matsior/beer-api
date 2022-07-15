package matsior.api.beer;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface BeerRepository extends PagingAndSortingRepository<Beer, Long> {
    List<Beer> findAll();
    List<Beer> findAll(Sort sort);
    List<Beer> findAllByCountryIgnoreCase(String country);
    List<Beer> findAllByAlcoholGreaterThanEqual(double alcohol);
    List<Beer> findAllByCountryContainsIgnoreCaseAndAlcoholGreaterThanEqual(String country, double alcohol, Sort sort);
    Optional<Beer> findByName(String name);
}