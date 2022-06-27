package matsior.api.style;

import matsior.api.style.dto.BeerStyleDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeerStyleService {
    private final BeerStyleRepository beerStyleRepository;

    public BeerStyleService(BeerStyleRepository beerStyleRepository) {
        this.beerStyleRepository = beerStyleRepository;
    }

    public List<BeerStyleDto> findAllStyles() {
        return beerStyleRepository.findAll()
                .stream()
                .map(beer -> new BeerStyleDto(
                        beer.getId(),
                        beer.getName(),
                        beer.getDescription()))
                .toList();
    }


    public Optional<BeerStyleDto> findById(Long id) {
        return beerStyleRepository.findById(id)
                .map(beer -> new BeerStyleDto(
                        beer.getId(),
                        beer.getName(),
                        beer.getDescription()));
    }

    public BeerStyleDto saveBeerStyle(BeerStyleDto beerStyleDto) {
        BeerStyle beerStyle = new BeerStyle(
                beerStyleDto.id(),
                beerStyleDto.name(),
                beerStyleDto.description());
        BeerStyle savedBeerStyle = beerStyleRepository.save(beerStyle);
        return new BeerStyleDto(
                savedBeerStyle.getId(),
                savedBeerStyle.getName(),
                savedBeerStyle.getDescription());
    }
}
