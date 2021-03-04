package org.dmitri.reviewapi.client;

import org.dmitri.reviewapi.model.dto.MovieDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/movie")
@FeignClient(name = "movie-api")
public interface MovieClient {

    @GetMapping("/{id}")
    MovieDto findById(@PathVariable Long id);

    @GetMapping("/list/{idList}")
    List<MovieDto> findByIdIn(@PathVariable List<Long> idList);
}
