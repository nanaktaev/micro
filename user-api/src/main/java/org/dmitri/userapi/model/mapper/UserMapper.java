package org.dmitri.userapi.model.mapper;


import org.dmitri.userapi.model.document.User;
import org.dmitri.userapi.model.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User fromDto(UserDto userDto);
}
