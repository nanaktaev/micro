package org.dmitri.movieapi.model.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Movie {

    @Id
    private Long id;
    private String title;
    private String directorName;
    private Date releaseDate;
}
