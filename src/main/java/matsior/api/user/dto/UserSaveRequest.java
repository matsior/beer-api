package matsior.api.user.dto;

public record UserSaveRequest (
        String username,
        String email,
        String password
) { }