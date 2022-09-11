package exceptions;

public class NotExistingRecord extends Exception{
    public NotExistingRecord(final String msg) {
        super(msg);
    }
}
