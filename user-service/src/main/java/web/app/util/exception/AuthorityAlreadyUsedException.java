package web.app.util.exception;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AuthorityAlreadyUsedException extends InvalidStateException {
    public static final String Authority_ALREADY_USED = "Authority \"%s\" already registered,try different authority";
    private static final long serialVersionUID = 1L;

    public AuthorityAlreadyUsedException(String authority) {
        super(String.format(Authority_ALREADY_USED, authority));
    }
}
