package web.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.app.domain.Role;
import web.app.domain.User;
import web.app.dto.auth.SignUpDto;
import web.app.dto.users.UserDto;
import web.app.repository.RoleRepository;
import web.app.repository.UserRepository;
import web.app.service.UserService;
import web.app.util.exception.AuthorityAlreadyUsedException;
import web.app.util.exception.errors.EmailAlreadyUsedException;
import web.app.util.mapper.UserMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    @Override
    public void signUp(SignUpDto dto) {
        userRepository.findByUsername(dto.getEmail())
                .ifPresent(user -> {
                    throw new EmailAlreadyUsedException(dto.getEmail());
                });

        userRepository.save(userMapper.dtoToEntity(dto));
    }

    @Override
    public List<UserDto> getUserList() {
        List<User> all = userRepository.findAll();
        return all.stream().map(userMapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    public Role save(Role role) {
        roleRepository.findByName(role.getName())
                .ifPresent(
                        auth -> {
                            throw new AuthorityAlreadyUsedException(role.getName());
                        });
        return roleRepository.save(role);
    }


    @Override
    @Transactional
    public void addAuthorityToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username).get();
        Role role = roleRepository.findByName(roleName).get();

        user.getRoles().add(role);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        if (userRepository.findByUsername(username).isPresent()){
            user = userRepository.findByUsername(username).get();
        } else {
            throw new UsernameNotFoundException("User is not found.");
        }
        List<SimpleGrantedAuthority> authorities  = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
