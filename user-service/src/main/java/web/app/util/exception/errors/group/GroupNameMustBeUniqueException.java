package web.app.util.exception.errors.group;


import web.app.util.exception.InvalidStateException;

public class GroupNameMustBeUniqueException extends InvalidStateException {

    public static final String MESSAGE = "A group called %s has already been used.";
    private static final long serialVersionUID = 5843213248811L;

    public GroupNameMustBeUniqueException(String groupName) {
        super(String.format(MESSAGE, groupName));
    }
}
