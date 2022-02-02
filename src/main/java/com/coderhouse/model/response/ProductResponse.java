package com.coderhouse.model.response;

import com.coderhouse.model.request.CategoryRequest;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {

    private String code;
    private String createDate;
    private String serviceTime;
    private Boolean status;
    private String type;
    private String description;
    private Double price;
    private CategoryResponse category;

}
