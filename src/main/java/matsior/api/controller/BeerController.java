package matsior.api.controller;

import matsior.api.model.Beer;
import matsior.api.model.BeerDto;
import matsior.api.service.BeerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping
    List<BeerDto> getAllBeers() {
        return beerService.getAll();
    }

//    @GetMapping("/{id}")
//    Beer findById(@PathVariable Long id) {
//        return beerRepository.findById(id).orElseThrow(RuntimeException::new);
//    }
}
