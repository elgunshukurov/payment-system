package web.app.dto.auth;

import web.app.util.validation.ValidPassword;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
public class SignUpDto {


    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @NotNull
    @ValidPassword
    private String password;

}
