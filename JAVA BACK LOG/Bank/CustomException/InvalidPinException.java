package Bank.CustomException;

public class InvalidPinException extends AccountException {
    public InvalidPinException(String message) {
        super(message);
    }
}
