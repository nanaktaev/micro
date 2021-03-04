package org.dmitri.reviewapi.service;


import org.dmitri.reviewapi.model.dto.ReviewDto;
import org.dmitri.reviewapi.model.dto.UserReviewsDto;

public interface ReviewService {

    UserReviewsDto findAllByUserId(Long userId);

    ReviewDto create(ReviewDto reviewDto);
}
