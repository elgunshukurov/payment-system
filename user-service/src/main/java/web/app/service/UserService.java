package web.app.service;

import web.app.domain.Role;
import web.app.dto.auth.SignUpDto;
import web.app.dto.users.UserDto;

import java.util.List;

public interface UserService {

    void signUp(SignUpDto signUpDto);

    List<UserDto> getUserList();

    Role save(Role role);
    void addAuthorityToUser(String username, String authority);
}
