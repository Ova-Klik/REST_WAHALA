package Bank.CustomException;

public class EmptyFieldException extends AccountException {
    public EmptyFieldException(String message) {
        super(message);
    }
}
