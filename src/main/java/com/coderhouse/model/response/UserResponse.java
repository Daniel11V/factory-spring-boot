package com.coderhouse.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

    private String code;
    private String name;
    private String type;
    private Boolean status;
    private String createDate;
    private Double numberReadings;
    private String serviceTime;

}
