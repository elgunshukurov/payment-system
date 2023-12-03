package web.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import web.app.domain.Role;
import web.app.dto.auth.SignUpDto;
import web.app.service.UserService;

import static web.app.util.constants.UserRole.*;

@EnableFeignClients
@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.save(Role.builder().name(ROLE_ANONYMOUS.getValue()).build());
            userService.save(Role.builder().name(ROLE_USER.getValue()).build());
            userService.save(Role.builder().name(ROLE_ADMIN.getValue()).build());
            userService.save(Role.builder().name(ROLE_SUPER_USER.getValue()).build());

            userService.signUp(SignUpDto.builder().name("John").email("jdoe@mail.ru").password("1234").build());

            userService.addAuthorityToUser("jdoe@mail.ru", ROLE_USER.getValue());
        };
    }

}
