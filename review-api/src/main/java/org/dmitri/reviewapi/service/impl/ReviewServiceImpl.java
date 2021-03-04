package org.dmitri.reviewapi.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dmitri.reviewapi.client.MovieClient;
import org.dmitri.reviewapi.client.UserClient;
import org.dmitri.reviewapi.exception.ResourceNotFoundException;
import org.dmitri.reviewapi.model.document.Review;
import org.dmitri.reviewapi.model.dto.MovieDto;
import org.dmitri.reviewapi.model.dto.ReviewDto;
import org.dmitri.reviewapi.model.dto.UserDto;
import org.dmitri.reviewapi.model.dto.UserReviewsDto;
import org.dmitri.reviewapi.model.mapper.ReviewMapper;
import org.dmitri.reviewapi.repository.ReviewRepository;
import org.dmitri.reviewapi.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final MovieClient movieClient;
    private final UserClient userClient;

    @Override
    public UserReviewsDto findAllByUserId(Long userId) {
        log.debug("Find all reviews by user id. userId = {}", userId);

        UserDto userDto = userClient.findById(userId);

        List<Review> reviews = reviewRepository.findByIdUserId(userId);
        if(reviews.isEmpty()) {
            throw new ResourceNotFoundException(String.format("User does not have any reviews yet. userId = %s", userId));
        }

        List<Long> movieIdList = reviews.stream().map(r -> r.getId().getMovieId()).collect(Collectors.toList());
        List<MovieDto> movieDtoList = movieClient.findByIdIn(movieIdList);

        return reviewMapper.toDto(userDto, reviews, movieDtoList);
    }

    @Override
    public ReviewDto create(ReviewDto reviewDto) {
        log.debug("Create review. reviewDto = {}", reviewDto);

        UserDto userDto = userClient.findById(reviewDto.getUserId());
        MovieDto movieDto = movieClient.findById(reviewDto.getMovieId());

        reviewRepository.save(reviewMapper.fromDto(reviewDto, userDto, movieDto));
        return reviewDto;
    }
}
