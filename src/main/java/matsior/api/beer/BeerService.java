package matsior.api.beer;

import matsior.api.beer.dto.BeerFullResponse;
import matsior.api.beer.dto.BeerSaveRequest;

import java.util.Optional;

interface BeerService {
    BeerSaveRequest saveBeer(BeerSaveRequest beerSaveRequest);
    Optional<BeerFullResponse> findBeerById(long id);
    void deleteBeer(Long id);
}
