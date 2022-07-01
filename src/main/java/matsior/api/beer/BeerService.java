package matsior.api.beer;

import lombok.RequiredArgsConstructor;
import matsior.api.beer.dto.BeerDto;
import matsior.api.beer.dto.BeerSaveRequestDto;
import matsior.api.beer.dto.BeerSimpleRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeerService {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    public List<BeerDto> findAllBeers() {
        return beerRepository.findAll()
                .stream()
                .map(beerMapper::map)
                .toList();
    }

    public List<BeerSimpleRequest> findAllBeersSimple() {
        return beerRepository.findAll()
                .stream()
                .map(beerMapper::mapToSimple)
                .toList();
    }

    public List<BeerDto> findAllBeersWithParameters(String country, double alcohol, String sortBy) {
        return beerRepository.findAllByCountryContainsIgnoreCaseAndAlcoholGreaterThanEqual(country, alcohol, Sort.by(sortBy))
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
        return beerMapper.mapToSaveRequest(savedBeer);
    }

    public void deleteBeer(Long id) {
        beerRepository.deleteById(id);
    }
}