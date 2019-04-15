package io.rad.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Choice {
    @Id
    private Long id;

    private String text;

    private Poll poll;

}
