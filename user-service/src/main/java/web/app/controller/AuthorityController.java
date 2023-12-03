package web.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.app.domain.Authority;
import web.app.service.UserService;

@RestController
@RequestMapping("/api/authorities")
@RequiredArgsConstructor
public class AuthorityController {

    private final UserService userService;

    @PostMapping
    public Authority save(@RequestBody Authority authority) {
        return userService.save(authority);
    }

}
