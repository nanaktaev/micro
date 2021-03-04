package org.dmitri.movieapi.controller;

import lombok.RequiredArgsConstructor;
import org.dmitri.movieapi.model.dto.MovieDto;
import org.dmitri.movieapi.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/{id}")
    public MovieDto findById(@PathVariable Long id) {
        return movieService.findById(id);
    }

    @GetMapping("/list/{idList}")
    public List<MovieDto> findByIdIn(@PathVariable List<Long> idList) {
        return movieService.findByIdIn(idList);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDto create(@RequestBody @Valid MovieDto movieDto) {
        return movieService.create(movieDto);
    }
}
