package matsior.api.producer;

import lombok.RequiredArgsConstructor;
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
}
