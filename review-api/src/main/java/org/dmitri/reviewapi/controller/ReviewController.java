package org.dmitri.reviewapi.controller;

import lombok.RequiredArgsConstructor;
import org.dmitri.reviewapi.model.dto.ReviewDto;
import org.dmitri.reviewapi.model.dto.UserReviewsDto;
import org.dmitri.reviewapi.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/user/{id}")
    public UserReviewsDto findAllByUserId(@PathVariable Long id) {
        return reviewService.findAllByUserId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewDto create(@RequestBody @Valid ReviewDto reviewDto) {
        return reviewService.create(reviewDto);
    }
}
