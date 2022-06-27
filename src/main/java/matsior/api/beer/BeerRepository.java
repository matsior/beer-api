package matsior.api.beer;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BeerRepository extends PagingAndSortingRepository<Beer, Long> {
    List<Beer> findAll();
    List<Beer> findAllByCountryIgnoreCase(String country);
    List<Beer> findAllByAlcoholGreaterThanEqual(double alcohol);
    List<Beer> findAllByCountryContainsIgnoreCaseAndAlcoholGreaterThanEqual(String country, double alcohol);
}