package matsior.api.beer.dto;

import com.fasterxml.jackson.annotation.JsonView;
import matsior.api.beer.BeerView;

public record BeerDto(
        @JsonView(BeerView.Simple.class)
        Long id,

        @JsonView(BeerView.Simple.class)
        String name,

        String country,

        Double alcohol,

        Double blg,

        @JsonView(BeerView.Simple.class)
        String beerStyle
) {
}