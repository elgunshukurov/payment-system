package web.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.app.domain.Authority;
import web.app.domain.User;
import web.app.dto.users.UserDto;
import web.app.repository.AuthorityRepository;
import web.app.repository.UserRepository;
import web.app.service.UserService;
import web.app.dto.auth.SignUpDto;
import web.app.util.exception.AuthorityAlreadyUsedException;
import web.app.util.exception.errors.EmailAlreadyUsedException;
import web.app.util.mapper.UserMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
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
    public Authority save(Authority authority) {
        authorityRepository.findByAuthority(authority.getAuthority())
                .ifPresent(
                        auth -> {
                            throw new AuthorityAlreadyUsedException(authority.getAuthority());
                        });
        return authorityRepository.save(authority);
    }


    @Override
    @Transactional
    public void addAuthorityToUser(String username, String authority) {
        User user = userRepository.findByUsername(username).get();
        Authority auth = authorityRepository.findByAuthority(authority).get();

        user.getAuthorities().add(auth);
    }


}
