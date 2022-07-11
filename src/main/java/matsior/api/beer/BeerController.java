package matsior.api.beer;

import matsior.api.beer.dto.BeerFullResponse;
import matsior.api.beer.dto.BeerSaveRequest;
import matsior.api.beer.dto.BeerSimpleResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(
        path = "/beers",
        produces = {
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
        }
)
class BeerController {

    private final BeerServiceImpl beerService;

    public BeerController(BeerServiceImpl beerService) {
        this.beerService = beerService;
    }

    @GetMapping
    List<BeerFullResponse> getAllBeers(
            @RequestParam(defaultValue = "") String country,
            @RequestParam(defaultValue = "0") Double alc,
            @RequestParam(defaultValue = "id") String sort
    ) {
        return beerService.findAllBeersWithParameters(country, alc, sort);
    }

    @GetMapping("/simple")
    List<BeerSimpleResponse> getSimpleInfo() {
        return beerService.findAllBeersSimple();
    }

    @GetMapping("/{id:[0-9]*}")
    ResponseEntity<BeerFullResponse> findBeerById(@PathVariable("id") Long id) {
        return beerService.findBeerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<BeerSaveRequest> saveBeer(@Valid @RequestBody BeerSaveRequest beerSaveRequest) {
        BeerSaveRequest savedBeer = beerService.saveBeer(beerSaveRequest);
        URI savedBeerUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedBeer.id())
                .toUri();
        return ResponseEntity.created(savedBeerUri).body(savedBeer);
    }

    // TODO add put mapping

    // TODO add patch mapping

    @DeleteMapping("/{id:[0-9]*}")
    ResponseEntity<?> deleteBeer(@PathVariable Long id) {
        beerService.deleteBeer(id);
        return ResponseEntity.noContent().build();
    }
}