package matsior.api.beer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeerDto {
    private Long id;
    private String name;
    private String country;
    private Double alcohol;
    private Double blg;
    private String beerStyle;
}