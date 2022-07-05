package matsior.api.producer;

import lombok.RequiredArgsConstructor;
import matsior.api.producer.dto.ProducerDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class ProducerService {

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

    public Optional<ProducerDto> replaceProducer(Long id, ProducerDto producerDto) {
        if (!producerRepository.existsById(id)) {
            return Optional.empty();
        }
        Producer producerToUpdate = producerMapper.map(id, producerDto);
        Producer updatedEntity = producerRepository.save(producerToUpdate);
        return Optional.of(producerMapper.map(updatedEntity));
    }

    @Transactional
    public Optional<ProducerDto> updateProducer(Long id, ProducerDto producerDto) {
        return producerRepository.findById(id)
                .map(target -> setEntityFields(producerDto, target))
                .map(producerMapper::map);
    }

    public void deleteProducer(Long id) {
        producerRepository.deleteById(id);
    }

    private Producer setEntityFields(ProducerDto source, Producer target) {
        if (source.name() != null) {
            target.setName(source.name());
        }
        if (source.description() != null) {
            target.setDescription(source.description());
        }
        return target;
    }
}
