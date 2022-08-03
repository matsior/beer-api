package matsior.api.producer;

import matsior.api.producer.dto.ProducerDto;
import org.springframework.stereotype.Component;

@Component
class ProducerMapper {
    public ProducerDto map(Producer producer) {
        return new ProducerDto(
                producer.getId(),
                producer.getName(),
                producer.getDescription()
        );
    }

    public Producer map(ProducerDto dto) {
        return new Producer(
                dto.id(),
                dto.name(),
                dto.description()
        );
    }

    public Producer map(Long id, ProducerDto producerDto) {
        return new Producer(
                id,
                producerDto.name(),
                producerDto.description()
        );
    }
}
