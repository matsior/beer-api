package matsior.api.style;

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
                .map(BeerStyleMapper::map)
                .toList();
    }


    public Optional<BeerStyleDto> findById(Long id) {
        return beerStyleRepository.findById(id)
                .map(BeerStyleMapper::map);
    }
}
