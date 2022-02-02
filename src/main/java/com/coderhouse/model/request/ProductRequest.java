package com.coderhouse.model.request;

import lombok.*;

import javax.validation.constraints.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @NotBlank(message = "El campo type no puede vacio")
    @Pattern(regexp = "^(TANGIBLE|INTANGIBLE)$", message = "Solo acepta: TANGIBLE, INTANGIBLE")
    private String type;
    private String description;
    @Max(50000)
    @Min(1)
    private Double price;
    private String serviceTime;
    @NotNull(message = "El campo category es obligatorio")
    private CategoryRequest category;
}
