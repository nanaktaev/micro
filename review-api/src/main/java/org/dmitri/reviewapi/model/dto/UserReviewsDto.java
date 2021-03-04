package org.dmitri.reviewapi.model.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserReviewsDto {

    private String email;
    private String firstName;
    private String lastName;
    private List<Movie> movies;

    @Data
    public static class Movie {

        private String title;
        private String directorName;
        private Date releaseDate;
        private Integer userRating;
        private String userComment;
    }
}
