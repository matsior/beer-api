package matsior.api.exceptionhandling;

record ExceptionMessage(
        String localDateTime,
        String httpStatus,
        Object message
) { }
