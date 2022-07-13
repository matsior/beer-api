package matsior.api.exceptionhandling;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
class ExceptionMessage {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    private final String localDateTime;
    private final String httpStatus;
    private final Object message;

    public ExceptionMessage(String httpStatus, Object message) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.localDateTime = LocalDateTime.now().format(DATE_TIME_FORMATTER);
    }
}
