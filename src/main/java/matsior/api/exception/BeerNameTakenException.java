package matsior.api.exception;

public class BeerNameTakenException extends RuntimeException {
    public BeerNameTakenException(String beerName) {
        super("Beer name: " + beerName + " is already taken");
    }
}
