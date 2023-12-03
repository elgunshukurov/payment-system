package web.app.util.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import web.app.domain.Role;
import web.app.domain.User;
import web.app.dto.RoleDto;
import web.app.dto.auth.SignUpDto;
import web.app.dto.users.UserDto;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Primary
public class CustomUserMapperImpl implements UserMapper{

    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDto entityToDto(User user) {
        Set<Role> roles = user.getRoles();

        UserDto userDto = new UserDto();
        userDto.setRoles(roles.stream().map(this::roleToRoleDto).collect(Collectors.toSet()));
        userDto.setEnabled(user.isEnabled());
        userDto.setAccountNonExpired(user.isAccountNonExpired());
        userDto.setAccountNonLocked(user.isAccountNonLocked());
        userDto.setCredentialsNonExpired(user.isCredentialsNonExpired());
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        return userDto;
    }

    public RoleDto roleToRoleDto(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setName(role.getName());
        roleDto.setId(role.getId());
        return roleDto;
    }



    @Override
    public User dtoToEntity(SignUpDto dto) {

//        Set<Role> roleSet = new HashSet<>();
//        Role role = new Role();
//        role.setName(ROLE_USER.getValue());
//        roleSet.add(role);

        User user = new User();
//        user.setRoles(roleSet);
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setName(dto.getName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setUsername(dto.getEmail());
        return user;
    }
}
