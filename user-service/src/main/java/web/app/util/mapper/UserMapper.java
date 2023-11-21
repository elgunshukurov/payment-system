package web.app.util.mapper;

import web.app.domain.User;
import web.app.dto.auth.SignUpDto;
import web.app.dto.users.UserDto;
import web.app.dto.users.UserInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.ReportingPolicy.IGNORE;

//@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface UserMapper {

    UserDto entityToDto(User user);

    User dtoToEntity(SignUpDto dto);

}
