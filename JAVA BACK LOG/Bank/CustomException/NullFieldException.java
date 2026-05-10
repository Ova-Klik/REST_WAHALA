package Bank.CustomException;

public class NullFieldException extends AccountException{
    public NullFieldException(String message) {
        super(message);
    }
}
