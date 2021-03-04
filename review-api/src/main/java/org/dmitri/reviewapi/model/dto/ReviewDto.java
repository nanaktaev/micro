package org.dmitri.reviewapi.model.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ReviewDto {

    @NotNull
    private Long userId;

    @NotNull
    private Long movieId;

    @Min(1)
    @Max(10)
    @NotNull
    private Integer userRating;

    @NotBlank
    private String userComment;
}
