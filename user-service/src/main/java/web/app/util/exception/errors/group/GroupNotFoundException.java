package web.app.util.exception.errors.group;


import web.app.util.exception.NotFoundException;

public class GroupNotFoundException extends NotFoundException {

    public static final String MESSAGE = "Group with id %s not Found.";
    private static final long serialVersionUID = 5843213248811L;

    public GroupNotFoundException(Long groupId) {
        super(String.format(MESSAGE, groupId));
    }
}
