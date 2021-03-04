package org.dmitri.userapi.controller;

import lombok.RequiredArgsConstructor;
import org.dmitri.userapi.model.dto.UserDto;
import org.dmitri.userapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody @Valid UserDto movieDto) {
        return userService.create(movieDto);
    }
}
