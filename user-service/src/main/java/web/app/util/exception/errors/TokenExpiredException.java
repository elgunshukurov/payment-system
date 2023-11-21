package web.app.util.exception.errors;


import web.app.util.exception.InvalidStateException;

public class TokenExpiredException extends InvalidStateException {

    public static final String TOKEN_EXPIRED = "Token expired";
    private static final long serialVersionUID = 3453246554321534L;

    public TokenExpiredException() {
        super(TOKEN_EXPIRED);
    }
}
