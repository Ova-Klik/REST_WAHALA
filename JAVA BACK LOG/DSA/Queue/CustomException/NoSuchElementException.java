package CustomException;

public class NoSuchElementException extends MyQueueException{
    public NoSuchElementException(String message) {
        super(message);
    }
}
