package web.app.util.exception.errors.group;


import web.app.util.exception.InvalidStateException;

public class GroupAlreadyExistException extends InvalidStateException {

    public static final String MESSAGE = "User with id %s is already in the group.";
    private static final long serialVersionUID = 5843213248811L;

    public GroupAlreadyExistException(Long userId) {
        super(String.format(MESSAGE, userId));
    }
}
