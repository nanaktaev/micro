package org.dmitri.reviewapi.model.mapper;

import org.dmitri.reviewapi.model.document.Review;
import org.dmitri.reviewapi.model.dto.MovieDto;
import org.dmitri.reviewapi.model.dto.ReviewDto;
import org.dmitri.reviewapi.model.dto.UserDto;
import org.dmitri.reviewapi.model.dto.UserReviewsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mapping(source = "reviewDto.userId", target = "id.userId")
    @Mapping(source = "reviewDto.movieId", target = "id.movieId")
    Review fromDto(ReviewDto reviewDto, UserDto userDto, MovieDto movieDto);

    default UserReviewsDto toDto(UserDto userDto, List<Review> reviews, List<MovieDto> movieDtoList) {
        List<UserReviewsDto.Movie> movies = new ArrayList<>();
        UserReviewsDto dto = new UserReviewsDto();
        dto.setEmail(userDto.getEmail());
        dto.setFirstName(userDto.getFirstName());
        dto.setLastName(userDto.getLastName());
        dto.setMovies(movies);

        Map<Long, MovieDto> movieDtoById = movieDtoList.stream().collect(Collectors.toMap(MovieDto::getId, movieDto -> movieDto));

        for (Review review : reviews) {
            MovieDto movieDto = movieDtoById.get(review.getId().getMovieId());
            UserReviewsDto.Movie movie = new UserReviewsDto.Movie();
            movie.setDirectorName(movieDto.getDirectorName());
            movie.setReleaseDate(movieDto.getReleaseDate());
            movie.setTitle(movieDto.getTitle());
            movie.setUserComment(review.getUserComment());
            movie.setUserRating(review.getUserRating());
            movies.add(movie);
        }

        return dto;
    }
}
