package org.dmitri.movieapi.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class MovieDto {

    @NotNull
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String directorName;

    @NotNull
    private Date releaseDate;
}
