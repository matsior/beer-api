package matsior.api.beer;

import lombok.RequiredArgsConstructor;
import matsior.api.beer.dto.BeerDto;
import matsior.api.beer.dto.BeerSaveRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeerService {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    public List<BeerDto> findAllBeers(String country, double alcohol) {
        if (country != null) {
            return beerRepository.findAll()
                    .stream()
                    .filter(beer -> beer.getCountry().equalsIgnoreCase(country))
                    .filter(beer -> beer.getAlcohol() >= alcohol)
                    .map(beerMapper::map)
                    .toList();
        } else {
            return beerRepository.findAll()
                    .stream()
                    .filter(beer -> beer.getAlcohol() >= alcohol)
                    .map(beerMapper::map)
                    .toList();
        }
    }

    public List<BeerDto> findAllBeersWithParameters(String country, double alcohol) {
        return beerRepository.findAllByCountryContainsIgnoreCaseAndAlcoholGreaterThanEqual(country, alcohol)
                .stream()
                .map(beerMapper::map)
                .toList();
    }

    public List<BeerDto> findAllBeers() {
        return beerRepository.findAll()
                .stream()
                .map(beerMapper::map)
                .toList();
    }

    public List<BeerDto> findAllBeers(double alcohol) {
        return beerRepository.findAll()
                .stream()
                .filter(beer -> beer.getAlcohol() >= alcohol)
                .map(beerMapper::map)
                .toList();
    }

    public List<BeerDto> findAllBeersByCountry(String country) {
        return beerRepository.findAllByCountryIgnoreCase(country)
                .stream()
                .map(beerMapper::map)
                .toList();
    }

    public List<BeerDto> findAllWithAlcoholGreaterThanEqual(double alcohol) {
        return beerRepository.findAllByAlcoholGreaterThanEqual(alcohol)
                .stream()
                .map(beerMapper::map)
                .toList();
    }

    public Optional<BeerDto> findBeerById(long id) {
        return beerRepository.findById(id)
                .map(beerMapper::map);
    }

    public BeerSaveRequestDto saveBeer(BeerSaveRequestDto beerSaveRequestDto) {
        Beer beerToSave = beerMapper.map(beerSaveRequestDto);
        Beer savedBeer = beerRepository.save(beerToSave);
        return beerMapper.mapToDto(savedBeer);
    }
}