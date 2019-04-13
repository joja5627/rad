package io.rad.web.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Data
@Builder
@ToString
@AllArgsConstructor
public class GenericResponse {
    private String message;
    private String error;
}
