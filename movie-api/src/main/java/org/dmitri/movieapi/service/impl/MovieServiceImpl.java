package org.dmitri.movieapi.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dmitri.movieapi.exception.ResourceNotFoundException;
import org.dmitri.movieapi.model.dto.MovieDto;
import org.dmitri.movieapi.model.document.Movie;
import org.dmitri.movieapi.model.mapper.MovieMapper;
import org.dmitri.movieapi.repository.MovieRepository;
import org.dmitri.movieapi.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public MovieDto findById(Long id) {
        log.debug("Find movie by id. id = {}", id);
        Movie movie = movieRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format("Movie not found. id = %s", id)));
        return movieMapper.toDto(movie);
    }

    @Override
    public MovieDto create(MovieDto movieDto) {
        log.debug("Create movie. movieDto = {}", movieDto);
        Movie movie = movieRepository.save(movieMapper.fromDto(movieDto));
        return movieMapper.toDto(movie);
    }

    @Override
    public List<MovieDto> findByIdIn(List<Long> idList) {
        log.debug("Find movies by id in. idList = {}", idList);
        List<Movie> movies = movieRepository.findByIdIn(idList);
        return movieMapper.toDto(movies);
    }
}
