package matsior.api.beer;

import lombok.RequiredArgsConstructor;
import matsior.api.beer.dto.BeerDto;
import matsior.api.beer.dto.BeerSaveRequestDto;
import matsior.api.style.BeerStyleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeerService {
    private static final Long EMPTY_ID = null;
    private final BeerRepository beerRepository;
    private final BeerStyleRepository beerStyleRepository;


    public List<BeerDto> findAllBeers() {
        return beerRepository.findAll()
                .stream()
                .map(beer -> new BeerDto(
                        beer.getId(),
                        beer.getName(),
                        beer.getCountry(),
                        beer.getAlcohol(),
                        beer.getBlg(),
                        beer.getBeerStyle().getName()))
                .toList();
    }

    public Optional<BeerDto> findBeerById(long id) {
        return beerRepository.findById(id)
                .map(beer -> new BeerDto(
                        beer.getId(),
                        beer.getName(),
                        beer.getCountry(),
                        beer.getAlcohol(),
                        beer.getBlg(),
                        beer.getBeerStyle().getName()));
    }

    public BeerSaveRequestDto saveBeer(BeerSaveRequestDto beerSaveRequestDto) {
        Beer beerToSave = new Beer(
                EMPTY_ID,
                beerSaveRequestDto.name(),
                beerSaveRequestDto.country(),
                beerSaveRequestDto.alcohol(),
                beerSaveRequestDto.blg(),
                beerStyleRepository.findById(beerSaveRequestDto.beerStyleId()).get());
        Beer savedBeer = beerRepository.save(beerToSave);
        return new BeerSaveRequestDto(
                savedBeer.getId(),
                savedBeer.getName(),
                savedBeer.getCountry(),
                savedBeer.getAlcohol(),
                savedBeer.getBlg(),
                savedBeer.getId());
    }
}