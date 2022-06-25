package matsior.api.beer;

import matsior.api.beer.dto.BeerDto;
import matsior.api.beer.dto.BeerSaveRequestDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeerService {
    private final BeerRepository beerRepository;
    private final ModelMapper modelMapper;

    public BeerService(BeerRepository beerRepository, ModelMapper modelMapper) {
        this.beerRepository = beerRepository;
        this.modelMapper = modelMapper;
    }

    public List<BeerDto> findAllBeers() {
        return beerRepository.findAll()
                .stream()
                .map(beer -> modelMapper.map(beer, BeerDto.class))
                .toList();
    }

    public Optional<BeerDto> findBeerById(long id) {
        return beerRepository.findById(id)
                .map(beer -> modelMapper.map(beer, BeerDto.class));
    }

    public BeerSaveRequestDto saveBeer(BeerSaveRequestDto beerSaveRequestDto) {
        Beer beerToSave = modelMapper.map(beerSaveRequestDto, Beer.class);
        Beer savedBeer = beerRepository.save(beerToSave);
        return modelMapper.map(savedBeer, BeerSaveRequestDto.class);
    }
}