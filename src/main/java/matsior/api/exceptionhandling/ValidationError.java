package matsior.api.exceptionhandling;

record ValidationError(
        String field,
        String message
) { }
