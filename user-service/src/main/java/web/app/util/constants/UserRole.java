package web.app.util.constants;

import lombok.Getter;

@Getter
public enum UserRole {
    ROLE_ANONYMOUS("ROLE_ANONYMOUS"),
    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_SUPER_USER("ROLE_SUPER_USER");

    private final String value;

    UserRole(String value) {
        this.value = value;
    }

}
