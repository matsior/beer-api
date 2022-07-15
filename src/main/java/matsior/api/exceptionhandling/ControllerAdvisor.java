package matsior.api.exceptionhandling;

import matsior.api.exceptionhandling.exception.BeerNameTakenException;
import matsior.api.exceptionhandling.exception.EmailTakenException;
import matsior.api.exceptionhandling.exception.UserNameTakenException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.List;

@ControllerAdvice
class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionMessage(
                        HttpStatus.BAD_REQUEST.toString(),
                        getValidationErrors(ex)
                ));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionMessage(
                        HttpStatus.BAD_REQUEST.toString(),
                        getValidationErrors(ex)
                ));
    }

    @ExceptionHandler(value = {
            BeerNameTakenException.class,
            EmailTakenException.class,
            UserNameTakenException.class
    })
    public ResponseEntity<Object> handleResourceAlreadyTakenException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionMessage(
                        HttpStatus.BAD_REQUEST.toString(),
                        ex.getMessage()
                ));
    }

    private List<ValidationError> getValidationErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> new ValidationError(err.getField(), err.getDefaultMessage()))
                .toList();
    }

    private List<ValidationError> getValidationErrors(ConstraintViolationException ex) {
        return ex.getConstraintViolations()
                .stream()
                .map(err -> new ValidationError(err.getPropertyPath().toString(), err.getMessage()))
                .toList();
    }
}
