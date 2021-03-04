package org.dmitri.userapi.model.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    @NotNull
    private Long id;

    @Email
    @NotNull
    private String email;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;
}
