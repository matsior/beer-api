package matsior.api.beer;

import matsior.api.beer.dto.BeerSaveRequest;

interface BeerService {
    BeerSaveRequest saveBeer(BeerSaveRequest beerSaveRequest);
}
