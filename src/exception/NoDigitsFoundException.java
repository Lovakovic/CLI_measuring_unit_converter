package exception;

public class NoDigitsFoundException extends InvalidInputException {

    private String message;

    public NoDigitsFoundException(String message) {
        super(message);
    }
}
