package matsior.api.producer;

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
