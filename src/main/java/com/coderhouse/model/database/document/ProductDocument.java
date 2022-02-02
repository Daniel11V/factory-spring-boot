package com.coderhouse.model.database.document;

import com.coderhouse.model.database.document.concrete.ProductIntangible;
import com.coderhouse.model.database.document.concrete.ProductTangible;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ProductIntangible.class, name = "productIntangible"),
        @JsonSubTypes.Type(value = ProductTangible.class, name = "productTangible")
})
@Document("product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public abstract class ProductDocument {

    @Id
    private String id;
    private String type;
    private String description;
    private Double price;
    private CategoryDocument category;
    private boolean status;
    private LocalDateTime createDate;

}
