package org.dmitri.userapi.model.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {

    @Id
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
}
