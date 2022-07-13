package matsior.api.exceptionhandling;

public record ValidationError(
        String field,
        String message
) { }
