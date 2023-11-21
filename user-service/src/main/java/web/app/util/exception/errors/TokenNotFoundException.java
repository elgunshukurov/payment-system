package web.app.util.exception.errors;


import web.app.util.exception.NotFoundException;

public class TokenNotFoundException extends NotFoundException {

    public static final String TOKEN_NOT_FOUND = "Token not found";
    private static final long serialVersionUID = 1465946412164612L;

    public TokenNotFoundException() {
        super(TOKEN_NOT_FOUND);
    }
}
