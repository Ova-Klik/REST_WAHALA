package CustomException;

public class EntryNotFoundException extends DiaryException {
    public EntryNotFoundException(String message) {
        super(message);
    }
}
