package matsior.api.producer;

import lombok.RequiredArgsConstructor;
import matsior.api.producer.dto.ProducerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/producers")
@RequiredArgsConstructor
class ProducerController {

    private final ProducerServiceImpl producerService;

    @GetMapping
    List<ProducerDto> findAll() {
        return producerService.getAllProducers();
    }

    @PostMapping
    ResponseEntity<ProducerDto> saveProducer(@Valid @RequestBody ProducerDto producerDto) {
        ProducerDto savedProducer = producerService.saveProducer(producerDto);
        URI savedProducerUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(savedProducer.id())
                .toUri();
        return ResponseEntity.created(savedProducerUri).body(savedProducer);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> replaceProducer(@PathVariable Long id, @RequestBody ProducerDto producerDto) {
        return producerService.replaceProducer(id, producerDto)
                .map(c -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    ResponseEntity<?> updateProducer(@PathVariable Long id, @RequestBody ProducerDto producerDto) {
        return producerService.updateProducer(id, producerDto)
                .map(p -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteProducer(@PathVariable Long id) {
        producerService.deleteProducer(id);
        return ResponseEntity.noContent().build();
    }
}