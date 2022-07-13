package matsior.api.producer.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record ProducerDto (
        Long id,

        @NotNull @Size(min = 2, max = 100)
        String name,

//        @Size(max = 2048)
        String description
) { }
