package matsior.api.controller;

import matsior.api.model.BeerDto;
import matsior.api.service.BeerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(
        path = "/api/beer",
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
    List<BeerDto> getAllBeers() {
        return beerService.findAllBeers();
    }

    @GetMapping("/{id}")
    BeerDto findBeerById(@PathVariable Long id) {
        return beerService.findBeerById(id).orElseThrow(IllegalArgumentException::new);
    }
}