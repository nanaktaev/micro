package org.dmitri.userapi.service;

import org.dmitri.userapi.model.dto.UserDto;

public interface UserService {

    UserDto findById(Long id);

    UserDto create(UserDto userDto);
}
