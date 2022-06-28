package matsior.api.beer.dto;

import matsior.api.producer.Producer;
import matsior.api.style.BeerStyle;

public record BeerDto(
        Long id,
        String name,
        String producerName,
        String description,
        String country,
        Double alcohol,
        Double blg,
        String beerStyleName
) {
}