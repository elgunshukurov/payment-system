package web.app.dto.users;

import web.app.dto.VerificationTokenDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto {

    private String email;
    private String name;
    private VerificationTokenDto verificationToken;

}
