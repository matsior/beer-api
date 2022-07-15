package matsior.api.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public record UserSaveRequest (
        @NotEmpty
        String username,
        @Email
        String email,
        String password
) { }