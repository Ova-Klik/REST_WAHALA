package CustomException;

public class MyQueueException extends RuntimeException {
    public MyQueueException(String message) {
        super(message);
    }
}
