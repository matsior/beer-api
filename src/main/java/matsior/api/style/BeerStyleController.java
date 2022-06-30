package matsior.api.style;

import matsior.api.style.dto.BeerStyleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/styles")
public class BeerStyleController {
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


}