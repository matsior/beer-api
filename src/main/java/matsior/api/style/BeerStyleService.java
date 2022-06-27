package matsior.api.style;

import lombok.RequiredArgsConstructor;
import matsior.api.style.dto.BeerStyleDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeerStyleService {
    private final BeerStyleRepository beerStyleRepository;
    private final BeerStyleMapper beerStyleMapper;

    public List<BeerStyleDto> findAllStyles() {
        return beerStyleRepository.findAll()
                .stream()
                .map(beerStyleMapper::map)
                .toList();
    }

    public Optional<BeerStyleDto> findById(Long id) {
        return beerStyleRepository.findById(id)
                .map(beerStyleMapper::map);
    }

    public BeerStyleDto saveBeerStyle(BeerStyleDto beerStyleDto) {
        BeerStyle beerStyle = new BeerStyle(
                beerStyleDto.id(),
                beerStyleDto.name(),
                beerStyleDto.description());
        BeerStyle savedBeerStyle = beerStyleRepository.save(beerStyle);
        return beerStyleMapper.map(savedBeerStyle);
    }
}
