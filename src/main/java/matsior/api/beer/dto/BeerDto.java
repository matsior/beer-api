package matsior.api.beer.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import matsior.api.beer.BeerView;

@Getter
@Setter
public class BeerDto {

    @JsonView(BeerView.Simple.class)
    private Long id;

    @JsonView(BeerView.Simple.class)
    private String name;

    private String country;

    private Double alcohol;

    private Double blg;

    @JsonView(BeerView.Simple.class)
    private String beerStyle;
}