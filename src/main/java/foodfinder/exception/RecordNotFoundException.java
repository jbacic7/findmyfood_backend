package foodfinder.exception;

public class RecordNotFoundException extends RuntimeException {

     String message;

    public RecordNotFoundException() {
        super();
    }

    public RecordNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
