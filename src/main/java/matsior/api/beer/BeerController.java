package matsior.api.beer;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import matsior.api.beer.dto.BeerFullResponse;
import matsior.api.beer.dto.BeerSaveRequest;
import matsior.api.beer.dto.BeerSimpleResponse;
import org.springframework.data.domain.Sort;
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
@Slf4j
class BeerController {

    private final BeerServiceImpl beerService;

    public BeerController(BeerServiceImpl beerService) {
        this.beerService = beerService;
    }

    @Operation(summary = "Get Beer list")
    @GetMapping
    List<BeerFullResponse> getAllBeers(
            @RequestParam(defaultValue = "") String country,
            @RequestParam(defaultValue = "0") Double alc,
            @RequestParam(defaultValue = "id") String sort
    ) {
        return beerService.findAllBeersWithParameters(country, alc, sort);
    }

    @Operation(summary = "Get simplified Beer list")
    @GetMapping("/simple")
    List<BeerSimpleResponse> getSimpleInfo(@RequestParam(defaultValue = "1") int page,
                                           @RequestParam(defaultValue = "ASC") Sort.Direction direction,
                                           @RequestParam(defaultValue = "id") String sortBy) {
        return beerService.findAllBeersSimple(page, direction, sortBy);
    }

    @Operation(summary = "Get single Beer by Id")
    @GetMapping("/{id:[0-9]*}")
    ResponseEntity<BeerFullResponse> findBeerById(@PathVariable("id") Long id) {
        return beerService.findBeerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Add new Beer")
    @PostMapping
    ResponseEntity<BeerSaveRequest> saveBeer(@Valid @RequestBody BeerSaveRequest beerSaveRequest) {
        BeerSaveRequest savedBeer = beerService.saveBeer(beerSaveRequest);
        URI savedBeerUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedBeer.id())
                .toUri();
        log.info("New beer added: [id: {}, name: '{}']", savedBeer.id(), savedBeer.name());
        return ResponseEntity.created(savedBeerUri).body(savedBeer);
    }

    // TODO add put mapping

    // TODO add patch mapping

    @Operation(summary = "Delete Beer by Id")
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteBeer(@PathVariable Long id) {
        beerService.deleteBeer(id);
        log.info("Deleted beer with id: {}", id);
        return ResponseEntity.noContent().build();
    }
}