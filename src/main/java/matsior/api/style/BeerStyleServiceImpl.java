package matsior.api.style;

import lombok.RequiredArgsConstructor;
import matsior.api.style.dto.BeerStyleDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class BeerStyleServiceImpl implements BeerStyleService {
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

    @Override
    public BeerStyleDto saveBeerStyle(BeerStyleDto beerStyleDto) {
        BeerStyle beerStyle = new BeerStyle(
                beerStyleDto.id(),
                beerStyleDto.name(),
                beerStyleDto.description());
        BeerStyle savedBeerStyle = beerStyleRepository.save(beerStyle);
        return beerStyleMapper.map(savedBeerStyle);
    }

    public Optional<BeerStyleDto> replaceBeerStyle(Long id, BeerStyleDto beerStyleDto) {
        if (!beerStyleRepository.existsById(id)) {
            return Optional.empty();
        }
        BeerStyle beerStyleToUpdate = beerStyleMapper.map(id, beerStyleDto);
        BeerStyle updatedEntity = beerStyleRepository.save(beerStyleToUpdate);
        return Optional.of(beerStyleMapper.map(updatedEntity));
    }

    @Transactional
    public Optional<BeerStyleDto> updateBeerStyle(Long id, BeerStyleDto beerStyleDto) {
        return beerStyleRepository.findById(id)
                .map(target -> setEntityFields(beerStyleDto, target))
                .map(beerStyleMapper::map);
    }

    public void deleteBeerStyle(Long id) {
        beerStyleRepository.deleteById(id);
    }

    private BeerStyle setEntityFields(BeerStyleDto source, BeerStyle target) {
        if (source.name() != null) {
            target.setName(source.name());
        }
        if (source.description() != null) {
            target.setDescription(source.description());
        }
        return target;
    }
}
