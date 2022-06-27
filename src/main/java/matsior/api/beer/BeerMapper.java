package matsior.api.beer;

import matsior.api.beer.dto.BeerDto;
import matsior.api.beer.dto.BeerSaveRequestDto;
import matsior.api.style.BeerStyleRepository;
import org.springframework.stereotype.Service;

@Service
public class BeerMapper {
    private static final Long EMPTY_ID = null;
    private final BeerStyleRepository beerStyleRepository;

    public BeerMapper(BeerStyleRepository beerStyleRepository) {
        this.beerStyleRepository = beerStyleRepository;
    }

    public BeerDto map(Beer beer) {
        return new BeerDto(
                beer.getId(),
                beer.getName(),
                beer.getCountry(),
                beer.getAlcohol(),
                beer.getBlg(),
                beer.getBeerStyle().getName());
    }

    public Beer map(BeerSaveRequestDto beerSaveRequestDto) {
        return new Beer(
                EMPTY_ID,
                beerSaveRequestDto.name(),
                beerSaveRequestDto.country(),
                beerSaveRequestDto.alcohol(),
                beerSaveRequestDto.blg(),
                beerStyleRepository.findById(beerSaveRequestDto.beerStyleId()).get());
    }

    public BeerSaveRequestDto mapToDto(Beer savedBeer) {
        return new BeerSaveRequestDto(
                savedBeer.getId(),
                savedBeer.getName(),
                savedBeer.getCountry(),
                savedBeer.getAlcohol(),
                savedBeer.getBlg(),
                savedBeer.getId());
    }
}
