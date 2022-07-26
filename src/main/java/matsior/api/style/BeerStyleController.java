package matsior.api.style;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import matsior.api.style.dto.BeerStyleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/styles")
@Slf4j
class BeerStyleController {
    private final BeerStyleServiceImpl beerStyleService;

    public BeerStyleController(BeerStyleServiceImpl beerStyleService) {
        this.beerStyleService = beerStyleService;
    }

    @Operation(summary = "Get beer styles list")
    @GetMapping
    List<BeerStyleDto> getAllStyles() {
        return beerStyleService.findAllStyles();
    }

    @Operation(summary = "Get single beer style by Id")
    @GetMapping("/{id}")
    ResponseEntity<BeerStyleDto> findStyleById(@PathVariable Long id) {
        return beerStyleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Add new beer style")
    @PostMapping
    ResponseEntity<BeerStyleDto> saveBeerStyle(@RequestBody BeerStyleDto beerStyle) {
        BeerStyleDto savedBeerStyle = beerStyleService.saveBeerStyle(beerStyle);
        URI savedBeerStyleUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(savedBeerStyle.id())
                .toUri();
        log.info("New beer style added: [id: {}, name: '{}']", savedBeerStyle.id(), savedBeerStyle.name());
        return ResponseEntity.created(savedBeerStyleUri).body(savedBeerStyle);
    }

    @Operation(summary = "Replace existing beer style by Id")
    @PutMapping("/{id}")
    ResponseEntity<?> replaceBeerStyle(@PathVariable Long id, @RequestBody BeerStyleDto beerStyleDto) {
        log.info("Replacing beer style with Id: {}", id);
        return beerStyleService.replaceBeerStyle(id, beerStyleDto)
                .map(beerStyle -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Partially update beer style by Id")
    @PatchMapping("/{id}")
    ResponseEntity<?> updateBeerStyle(@PathVariable Long id, @RequestBody BeerStyleDto beerStyleDto) {
        log.info("Updating beer style with Id: {}", id);
        return beerStyleService.updateBeerStyle(id, beerStyleDto)
                .map(beerStyle -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete beer style by Id")
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteBeerStyle(@PathVariable Long id) {
        beerStyleService.deleteBeerStyle(id);
        log.info("Deleted beer style with id: {}", id);
        return ResponseEntity.noContent().build();
    }
}