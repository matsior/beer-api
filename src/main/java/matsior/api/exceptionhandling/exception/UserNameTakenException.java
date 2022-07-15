package matsior.api.exceptionhandling.exception;

public class UserNameTakenException extends RuntimeException {
    public UserNameTakenException(String username) {
        super("User name: " + username + " is already taken");
    }
}
