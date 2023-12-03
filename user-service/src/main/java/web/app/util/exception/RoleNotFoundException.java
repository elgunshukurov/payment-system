package web.app.util.exception;

public class RoleNotFoundException extends NotFoundException {

    public static final String ROLE_NOT_FOUND = "Role Not Found";

    private static final long serialVersionUID = 58432132465811L;

    public RoleNotFoundException(String roleName) {
        super(String.format("Role \"%s\" not found", roleName));
    }

    public RoleNotFoundException(String param, String roleName) {
        super(String.format("Role with \"%s\" - \"%s\" not found", param, roleName));
    }

    public RoleNotFoundException() {
        super(ROLE_NOT_FOUND);
    }
}
