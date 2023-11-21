package web.app.security;

public enum UserRole {
    ROLE_ANONYMOUS,
    ROLE_USER, //user that has just registered in the web site, not using any services
    ROLE_ADMIN, //manages all info in the course
    ROLE_SUPER_USER;

}
