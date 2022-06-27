package matsior.api.beer.dto;

public record BeerSaveRequestDto(
        Long id,
        String name,
        Long producerId,
        String description,
        String country,
        Double alcohol,
        Double blg,
        Long beerStyleId
) { }