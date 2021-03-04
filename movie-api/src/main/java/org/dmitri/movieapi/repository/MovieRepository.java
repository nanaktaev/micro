package org.dmitri.movieapi.repository;

import org.dmitri.movieapi.model.document.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, Long> {

    List<Movie> findByIdIn(List<Long> idList);
}
