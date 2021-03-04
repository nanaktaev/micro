package org.dmitri.reviewapi.repository;

import org.dmitri.reviewapi.model.document.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, Long> {

    List<Review> findByIdUserId(Long userId);
}
