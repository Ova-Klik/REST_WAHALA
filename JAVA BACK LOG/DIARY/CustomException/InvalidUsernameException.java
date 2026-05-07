package CustomException;

public class InvalidUsernameException extends DiaryException {
    public InvalidUsernameException(String message) {
        super(message);
    }
}
