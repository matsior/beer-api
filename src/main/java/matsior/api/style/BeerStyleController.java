package matsior.api.style;

import matsior.api.style.dto.BeerStyleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/styles")
class BeerStyleController {
    private final BeerStyleService beerStyleService;

    public BeerStyleController(BeerStyleService beerStyleService) {
        this.beerStyleService = beerStyleService;
    }

    @GetMapping
    List<BeerStyleDto> getAllStyles() {
        return beerStyleService.findAllStyles();
    }

    @GetMapping("/{id}")
    ResponseEntity<BeerStyleDto> findStyleById(@PathVariable Long id) {
        return beerStyleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<BeerStyleDto> saveBeerStyle(@RequestBody BeerStyleDto beerStyle) {
        BeerStyleDto savedBeerStyle = beerStyleService.saveBeerStyle(beerStyle);
        URI savedBeerStyleUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(savedBeerStyle.id())
                .toUri();
        return ResponseEntity.created(savedBeerStyleUri).body(savedBeerStyle);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> replaceBeerStyle(@PathVariable Long id, @RequestBody BeerStyleDto beerStyleDto) {
        return beerStyleService.replaceBeerStyle(id, beerStyleDto)
                .map(c -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    ResponseEntity<?> updateBeerStyle(@PathVariable Long id, @RequestBody BeerStyleDto beerStyleDto) {
        return beerStyleService.updateBeerStyle(id, beerStyleDto)
                .map(b -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteBeerStyle(@PathVariable Long id) {
        beerStyleService.deleteBeerStyle(id);
        return ResponseEntity.noContent().build();
    }
}