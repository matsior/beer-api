package matsior.api.producer;

import lombok.RequiredArgsConstructor;
import matsior.api.beer.Beer;
import matsior.api.beer.dto.BeerSaveRequestDto;
import matsior.api.producer.dto.ProducerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private final ProducerRepository producerRepository;
    private final ProducerMapper producerMapper;

    public List<ProducerDto> getAllProducers() {
        return producerRepository.findAll()
                .stream()
                .map(producerMapper::map)
                .toList();
    }

    public ProducerDto saveProducer(ProducerDto producerToSaveDto) {
        Producer producerToSave = producerMapper.map(producerToSaveDto);
        Producer savedProducer = producerRepository.save(producerToSave);
        return producerMapper.map(savedProducer);

    }
}
