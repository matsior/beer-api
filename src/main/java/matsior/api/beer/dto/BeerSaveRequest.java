package matsior.api.beer.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record BeerSaveRequest(
        Long id,

        @NotNull @Size(min = 2, max = 50, message = "name must be between 2 and 50 characters")
        String name,

        @NotNull @Min(0)
        Long producerId,

        @Size(max = 2048)
        String description,

        @Size(min = 4, max = 60, message = "Country name must be between 4 and 60 characters")
        String country,

        @Min(0)
        Double alcohol,

        @Min(0)
        Double blg,

        @NotNull @Min(0)
        Long beerStyleId
) { }
