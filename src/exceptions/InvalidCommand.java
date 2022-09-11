package exceptions;

public class InvalidCommand extends Exception {
    public InvalidCommand(final String msg) {
        super(msg);
    }
}
