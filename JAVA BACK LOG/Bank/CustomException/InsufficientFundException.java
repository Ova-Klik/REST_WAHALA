package Bank.CustomException;

public class InsufficientFundException extends AccountException {
    public InsufficientFundException(String message) {
        super(message);
    }
}
