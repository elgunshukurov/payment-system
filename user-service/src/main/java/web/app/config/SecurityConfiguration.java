package web.app.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import web.app.security.auth.services.CustomUserDetailsService;
import web.app.security.auth.services.JwtService;
import web.app.security.auth.services.TokenAuthService;

import java.util.List;

@Slf4j
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends BaseSecurityConfig {

    public SecurityConfiguration(SecurityProperties securityProperties, JwtService jwtService) {
        super(securityProperties, List.of(new TokenAuthService(jwtService)));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/users/sign-in"
//                        ,"/api/users/**"
                )
                .permitAll()
                .and()
                .authorizeRequests()
        ;

        super.configure(http);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
