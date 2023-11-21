package web.app.util.exception.errors.group;


import web.app.util.exception.NotFoundException;

public class UserNotFoundException extends NotFoundException {

    public static final String MESSAGE = "User with id %s not Found.";
    private static final long serialVersionUID = 5843213248811L;

    public UserNotFoundException(Long userId) {
        super(String.format(MESSAGE, userId));
    }
}
