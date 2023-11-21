package web.app.util.exception.errors;


import web.app.util.exception.InvalidStateException;

public class UserIsNotActiveException extends InvalidStateException {

    private static final long serialVersionUID = 58432132465811L;

    public UserIsNotActiveException() {
        super("The user is not active. Please activate your account");
    }
}
