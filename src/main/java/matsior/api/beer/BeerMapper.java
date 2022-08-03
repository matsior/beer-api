package matsior.api.beer;

import lombok.RequiredArgsConstructor;
import matsior.api.beer.dto.BeerFullResponse;
import matsior.api.beer.dto.BeerSaveRequest;
import matsior.api.beer.dto.BeerSimpleResponse;
import matsior.api.producer.ProducerRepository;
import matsior.api.style.BeerStyleRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeerMapper {
    private final BeerStyleRepository beerStyleRepository;
    private final ProducerRepository producerRepository;

    public BeerFullResponse map(Beer beer) {
        return new BeerFullResponse(
                beer.getId(),
                beer.getName(),
                beer.getProducer().getName(),
                beer.getDescription(),
                beer.getCountry(),
                beer.getAlcohol(),
                beer.getBlg(),
                beer.getBeerStyle().getName(),
                beer.getDateAdded());
    }

    public Beer map(BeerSaveRequest beerSaveRequest) {
        return new Beer(
                beerSaveRequest.name(),
                producerRepository.findById(beerSaveRequest.producerId()).get(),
                beerSaveRequest.description(),
                beerSaveRequest.country(),
                beerSaveRequest.alcohol(),
                beerSaveRequest.blg(),
                beerStyleRepository.findById(beerSaveRequest.beerStyleId()).get()
        );
    }

    public BeerSaveRequest mapToSaveRequest(Beer savedBeer) {
        return new BeerSaveRequest(
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

    public BeerSimpleResponse mapToSimple(Beer beer) {
        return new BeerSimpleResponse(beer.getId(), beer.getName());
    }
}
