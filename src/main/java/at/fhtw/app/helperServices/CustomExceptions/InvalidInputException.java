package at.fhtw.app.helperServices.CustomExceptions;

public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
