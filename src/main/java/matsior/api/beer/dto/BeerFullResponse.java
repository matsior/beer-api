package matsior.api.beer.dto;

public record BeerFullResponse(
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