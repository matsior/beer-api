package matsior.api.style;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeerStyleService {
    private final BeerStyleRepository beerStyleRepository;
    private final ModelMapper modelMapper;

    public BeerStyleService(BeerStyleRepository beerStyleRepository, ModelMapper modelMapper) {
        this.beerStyleRepository = beerStyleRepository;
        this.modelMapper = modelMapper;
    }

    public List<BeerStyleDto> findAllStyles() {
        return beerStyleRepository.findAll()
                .stream()
                .map(beerStyle -> modelMapper.map(beerStyle, BeerStyleDto.class))
                .toList();
    }


    public Optional<BeerStyleDto> findById(Long id) {
        return beerStyleRepository.findById(id)
                .map(beerStyle -> modelMapper.map(beerStyle, BeerStyleDto.class));
    }
}
