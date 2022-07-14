package matsior.api.producer;

import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Get beer producers list")
    @GetMapping
    List<ProducerDto> findAll() {
        return producerService.getAllProducers();
    }

    @Operation(summary = "Add new producer")
    @PostMapping
    ResponseEntity<ProducerDto> saveProducer(@Valid @RequestBody ProducerDto producerDto) {
        ProducerDto savedProducer = producerService.saveProducer(producerDto);
        URI savedProducerUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(savedProducer.id())
                .toUri();
        return ResponseEntity.created(savedProducerUri).body(savedProducer);
    }

    @Operation(summary = "Replace existing producer by Id")
    @PutMapping("/{id}")
    ResponseEntity<?> replaceProducer(@PathVariable Long id,@Valid @RequestBody ProducerDto producerDto) {
        return producerService.replaceProducer(id, producerDto)
                .map(producer -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Partially update producer by Id")
    @PatchMapping("/{id}")
    ResponseEntity<?> updateProducer(@PathVariable Long id, @Valid @RequestBody ProducerDto producerDto) {
        return producerService.updateProducer(id, producerDto)
                .map(producer -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }


    @Operation(summary = "Delete producer by Id")
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteProducer(@PathVariable Long id) {
        producerService.deleteProducer(id);
        return ResponseEntity.noContent().build();
    }
}