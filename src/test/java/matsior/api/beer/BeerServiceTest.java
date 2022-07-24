package matsior.api.beer;

import matsior.api.beer.dto.BeerFullResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class BeerServiceTest {

    @Autowired
    private BeerService beerService;

    @Test
    void shouldGetSingleBeer() {
        // given

        // when
        Optional<BeerFullResponse> beerById = beerService.findBeerById(1L);
        // then
        assertThat(beerById).isNotNull();
        BeerFullResponse beer = beerById.get();
        assertThat(beer.id()).isEqualTo(1L);

    }
}