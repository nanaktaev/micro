package org.dmitri.userapi.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dmitri.userapi.exception.ResourceNotFoundException;
import org.dmitri.userapi.model.document.User;
import org.dmitri.userapi.model.dto.UserDto;
import org.dmitri.userapi.model.mapper.UserMapper;
import org.dmitri.userapi.repository.UserRepository;
import org.dmitri.userapi.service.UserService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto findById(Long id) {
        log.debug("Find user by id. id = {}", id);
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format("User not found. id = %s", id)));
        return userMapper.toDto(user);
    }

    @Override
    public UserDto create(UserDto userDto) {
        log.debug("Create user. userDto = {}", userDto);
        User user = userRepository.save(userMapper.fromDto(userDto));
        return userMapper.toDto(user);
    }
}
