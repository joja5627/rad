package io.rad.web.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChoiceRequest {
    @NotBlank
    @Size(max = 40)
    private String text;
}
