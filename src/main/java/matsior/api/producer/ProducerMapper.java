package matsior.api.producer;

import matsior.api.producer.dto.ProducerDto;
import org.springframework.stereotype.Service;

@Service
public class ProducerMapper {
    public ProducerDto map(Producer producer) {
        return new ProducerDto(
                producer.getId(),
                producer.getName(),
                producer.getDescription()
        );
    }
}
