package web.app.util.exception.errors;


import web.app.util.exception.InvalidStateException;

public class NewPasswordsNotMatchException extends InvalidStateException {

    public static final String PASSWORDS_DO_NOT_MATCH = "Passwords do not match.";

    private static final long serialVersionUID = 345324655432534L;

    public NewPasswordsNotMatchException() {
        super(PASSWORDS_DO_NOT_MATCH);
    }
}
