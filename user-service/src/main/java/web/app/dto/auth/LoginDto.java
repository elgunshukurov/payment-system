package web.app.dto.auth;

import web.app.util.constants.PasswordConstants;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ToString(exclude = "password")
public class LoginDto {

    @NotNull
    @Size(min = 1, max = 50)
    private String email;

    @NotNull
    @Size(min = PasswordConstants.PASSWORD_MIN_LENGTH, max = PasswordConstants.PASSWORD_MAX_LENGTH)
    private String password;

    private Boolean rememberMe;

}
