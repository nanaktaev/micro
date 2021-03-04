package org.dmitri.reviewapi.model.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document
public class Review {

    @Id
    private ReviewId id;
    private Integer userRating;
    private String userComment;

    @Data
    public static class ReviewId implements Serializable {

        private Long userId;
        private Long movieId;
    }
}
