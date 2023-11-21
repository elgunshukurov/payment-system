package web.app.dto.auth;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.validation.constraints.NotNull;

@Data
public class AuthorityDto implements GrantedAuthority {

    public static final String TABLE_NAME = "authorities";
    private static final long serialVersionUID = -1887785494532505153L;

    @NotNull
    private Long id;

    @NotNull
    private String authority;

    private String title;

}

