package matsior.api.beer.dto;

import java.time.Instant;

public record BeerFullResponse(
        Long id,
        String name,
        String producerName,
        String description,
        String country,
        Double alcohol,
        Double blg,
        String beerStyleName,
        Instant dateAdded
) { }