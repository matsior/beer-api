package matsior.api.user.dto;

import java.time.Instant;

public record UserFullResponse(
        Long id,
        String username,
        String email,
        String password,
        Instant created
) { }
