package web.app.security.auth.services;

import org.springframework.security.core.Authentication;

public interface ClaimSetProvider {

    ClaimSet provide(Authentication authentication);
}
