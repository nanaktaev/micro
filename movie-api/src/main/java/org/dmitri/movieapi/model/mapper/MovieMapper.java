package org.dmitri.movieapi.model.mapper;

import org.dmitri.movieapi.model.dto.MovieDto;
import org.dmitri.movieapi.model.document.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieDto toDto(Movie movie);

    List<MovieDto> toDto(List<Movie> movies);

    Movie fromDto(MovieDto movieDto);
}
