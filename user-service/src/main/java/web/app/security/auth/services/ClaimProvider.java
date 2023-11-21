package web.app.security.auth.services;

import org.springframework.security.core.Authentication;

public interface ClaimProvider {

    Claim provide(Authentication authentication);
}
