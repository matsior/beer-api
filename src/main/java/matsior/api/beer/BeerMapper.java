package matsior.api.beer;

import lombok.RequiredArgsConstructor;
import matsior.api.beer.dto.BeerDto;
import matsior.api.beer.dto.BeerSaveRequestDto;
import matsior.api.producer.ProducerRepository;
import matsior.api.style.BeerStyleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BeerMapper {
    private static final Long EMPTY_ID = null;
    private final BeerStyleRepository beerStyleRepository;
    private final ProducerRepository producerRepository;

    public BeerDto map(Beer beer) {
        return new BeerDto(
                beer.getId(),
                beer.getName(),
                beer.getProducer().getName(),
                beer.getDescription(),
                beer.getCountry(),
                beer.getAlcohol(),
                beer.getBlg(),
                beer.getBeerStyle().getName());
    }

    public Beer map(BeerSaveRequestDto beerSaveRequestDto) {
        return new Beer(
                EMPTY_ID,
                beerSaveRequestDto.name(),
                producerRepository.findById(beerSaveRequestDto.producerId()).get(),
                beerSaveRequestDto.description(),
                beerSaveRequestDto.country(),
                beerSaveRequestDto.alcohol(),
                beerSaveRequestDto.blg(),
                beerStyleRepository.findById(beerSaveRequestDto.beerStyleId()).get()
        );
    }

    public BeerSaveRequestDto mapToSaveRequest(Beer savedBeer) {
        return new BeerSaveRequestDto(
                savedBeer.getId(),
                savedBeer.getName(),
                savedBeer.getProducer().getId(),
                savedBeer.getDescription(),
                savedBeer.getCountry(),
                savedBeer.getAlcohol(),
                savedBeer.getBlg(),
                savedBeer.getBeerStyle().getId()
        );
    }
}
