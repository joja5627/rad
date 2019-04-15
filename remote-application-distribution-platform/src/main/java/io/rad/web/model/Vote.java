package io.rad.web.model;


import io.rad.web.model.audit.DateAudit;
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
public class Vote extends DateAudit {

    @Id
    private Long id;
    private Poll poll;
    private Choice choice;
    private User user;

}
