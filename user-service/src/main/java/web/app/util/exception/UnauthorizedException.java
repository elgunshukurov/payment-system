package web.app.util.exception;

public class UnauthorizedException extends RuntimeException {

    private static final long serialVersionUID = 5853558719338611079L;
    private static final String MESSAGE = "Unauthorized";

    public UnauthorizedException() {
        super(MESSAGE);
    }

    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

}
