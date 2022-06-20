package matsior.api.service;

import matsior.api.model.BeerDto;
import matsior.api.model.BeerMapper;
import matsior.api.repository.BeerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeerService {
    private final BeerRepository beerRepository;

    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public List<BeerDto> findAllBeers() {
        return beerRepository.findAll()
                .stream()
                .map(BeerMapper::map)
                .toList();
    }

    public Optional<BeerDto> findBeerById(long id) {
        return beerRepository.findById(id).map(BeerMapper::map);
    }
}
