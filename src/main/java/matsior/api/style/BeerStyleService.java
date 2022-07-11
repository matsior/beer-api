package matsior.api.style;

import matsior.api.style.dto.BeerStyleDto;

interface BeerStyleService {
    BeerStyleDto saveBeerStyle(BeerStyleDto beerStyleDto);
}
