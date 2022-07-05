package matsior.api.style;

import matsior.api.style.dto.BeerStyleDto;
import org.springframework.stereotype.Service;

@Service
class BeerStyleMapper {
    public BeerStyleDto map(BeerStyle beer) {
        return new BeerStyleDto(
                beer.getId(),
                beer.getName(),
                beer.getDescription());
    }

    public BeerStyle map(Long id, BeerStyleDto beerStyleDto) {
        return new BeerStyle(
                id,
                beerStyleDto.name(),
                beerStyleDto.description()
        );
    }
}
