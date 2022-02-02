package com.coderhouse.model.request;

import lombok.*;

import javax.validation.constraints.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "El campo type no puede estar vacio")
    @Pattern(regexp = "^(ADMIN|EDITOR|CLIENT)$", message = "Solo acepta: Admin, Editor, Client")
    private String type;
    @NotNull(message = "El campo name es obligatorio")
    private String name;
    @Max(50000)
    @Min(1)
    private Double numberReadings;
    private String serviceTime;
}
