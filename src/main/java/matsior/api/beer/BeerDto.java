package matsior.api.beer;

public record BeerDto(Long id,
                      String name,
                      String country,
                      Double alcohol,
                      Double blg,
                      String beerStyle) { }