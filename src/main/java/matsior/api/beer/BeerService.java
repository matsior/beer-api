package matsior.api.beer;

import lombok.RequiredArgsConstructor;
import matsior.api.beer.dto.BeerFullResponse;
import matsior.api.beer.dto.BeerSaveRequest;
import matsior.api.beer.dto.BeerSimpleResponse;
import matsior.api.exception.BeerNameTakenException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class BeerService {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    public List<BeerFullResponse> findAllBeers() {
        return beerRepository.findAll()
                .stream()
                .map(beerMapper::map)
                .toList();
    }

    public List<BeerSimpleResponse> findAllBeersSimple() {
        return beerRepository.findAll()
                .stream()
                .map(beerMapper::mapToSimple)
                .toList();
    }

    public List<BeerFullResponse> findAllBeersWithParameters(String country, double alcohol, String sortBy) {
        return beerRepository.findAllByCountryContainsIgnoreCaseAndAlcoholGreaterThanEqual(country, alcohol, Sort.by(sortBy))
                .stream()
                .map(beerMapper::map)
                .toList();
    }

    public Optional<BeerFullResponse> findBeerById(long id) {
        return beerRepository.findById(id)
                .map(beerMapper::map);
    }

    public BeerSaveRequest saveBeer(BeerSaveRequest beerSaveRequest) {
        beerRepository.findByName(beerSaveRequest.name()).ifPresent(beer -> {
                    throw new BeerNameTakenException(beerSaveRequest.name());
                });

        Beer beerToSave = beerMapper.map(beerSaveRequest);
        Beer savedBeer = beerRepository.save(beerToSave);
        return beerMapper.mapToSaveRequest(savedBeer);
    }

    public void deleteBeer(Long id) {
        beerRepository.deleteById(id);
    }
}