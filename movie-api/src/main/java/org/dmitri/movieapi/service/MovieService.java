package org.dmitri.movieapi.service;

import org.dmitri.movieapi.model.dto.MovieDto;

import java.util.List;

public interface MovieService {

    MovieDto findById(Long id);

    MovieDto create(MovieDto movieDto);

    List<MovieDto> findByIdIn(List<Long> id);
}
