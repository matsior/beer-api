package matsior.api.beer.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record BeerSaveRequest(
        Long id,
        @NotNull @Size(min = 2, max = 50)
        String name,
        @NotNull @Min(0)
        Long producerId,
        String description,
        @Size(min = 2, max = 100)
        String country,
        @Min(0)
        Double alcohol,
        @Min(0)
        Double blg,
        @NotNull @Min(0)
        Long beerStyleId
) { }
