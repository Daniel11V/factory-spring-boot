package com.coderhouse.model.database.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("category")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDocument {

    @Id
    private String id;
    private String description;
}
