package CustomException;

public class InvalidPasswordException extends DiaryException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
