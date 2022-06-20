package matsior.api.service;

import matsior.api.model.BeerDto;
import matsior.api.model.BeerMapper;
import matsior.api.repository.BeerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerService {
    private final BeerRepository beerRepository;

    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public List<BeerDto> getAll() {
        return beerRepository.findAll()
                .stream()
                .map(BeerMapper::map)
                .toList();
    }
}
