package matsior.api.beer;

import com.fasterxml.jackson.annotation.JsonView;
import matsior.api.beer.dto.BeerDto;
import matsior.api.beer.dto.BeerSaveRequestDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(
        path = "/api/beers",
        produces = {
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
        }
)
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping
    List<BeerDto> getAllBeers(
            @RequestParam(defaultValue = "") String country,
            @RequestParam(defaultValue = "0") Double alc,
            @RequestParam(defaultValue = "id") String sort
    ) {
        return beerService.findAllBeersWithParameters(country, alc, sort);
    }

    @GetMapping("/{id}")
    ResponseEntity<BeerDto> findBeerById(@PathVariable("id") Long id) {
        return beerService.findBeerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<BeerSaveRequestDto> saveBeer(@RequestBody BeerSaveRequestDto beerSaveRequestDto) {
        BeerSaveRequestDto savedBeer = beerService.saveBeer(beerSaveRequestDto);
        URI savedBeerUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedBeer.id())
                .toUri();
        return ResponseEntity.created(savedBeerUri).body(savedBeer);
    }
}