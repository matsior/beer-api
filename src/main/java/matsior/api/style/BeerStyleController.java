package matsior.api.style;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/style")
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
}