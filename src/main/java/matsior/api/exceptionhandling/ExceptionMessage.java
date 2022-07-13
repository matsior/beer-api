package matsior.api.exceptionhandling;

public record ExceptionMessage(
        String localDateTime,
        String httpStatus,
        Object message
) { }
