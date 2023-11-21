package web.app.util.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import web.app.domain.Authority;
import web.app.domain.User;
import web.app.dto.auth.AuthorityDto;
import web.app.dto.auth.SignUpDto;
import web.app.dto.users.UserDto;
import web.app.dto.users.UserInfoDto;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Primary
public class CustomUserMapperImpl implements UserMapper{

    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDto entityToDto(User user) {
        Set<Authority> authorities = user.getAuthorities();

        UserDto userDto = new UserDto();
        userDto.setAuthorities(authorities.stream().map(this::authorityToAuthorityDto).collect(Collectors.toSet()));
        userDto.setEnabled(user.isEnabled());
        userDto.setAccountNonExpired(user.isAccountNonExpired());
        userDto.setAccountNonLocked(user.isAccountNonLocked());
        userDto.setCredentialsNonExpired(user.isCredentialsNonExpired());
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        return userDto;
    }

    public AuthorityDto authorityToAuthorityDto(Authority authority) {
        AuthorityDto authorityDto = new AuthorityDto();
        authorityDto.setAuthority(authority.getAuthority());
        authorityDto.setId(authority.getId());
//        authorityDto.setTitle(authority.ge);
        return authorityDto;
    }



    @Override
    public User dtoToEntity(SignUpDto dto) {

        User user = new User();
//        user.setAuthorities(authorities.stream().map(this::authorityToAuthorityDto).collect(Collectors.toSet()));
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
