package matsior.api.producer;

import matsior.api.producer.dto.ProducerDto;

interface ProducerService {
    ProducerDto saveProducer(ProducerDto producerToSaveDto);
}
