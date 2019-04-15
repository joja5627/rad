package io.rad.web.model;

import io.rad.web.model.audit.UserDateAudit;
import javafx.scene.control.ChoiceDialog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Poll extends UserDateAudit {
    @Id
    private Long id;

    @NotBlank
    @Size(max = 140)
    private String question;

    @Size(min = 2, max = 6)
    private List<Choice> choices = new ArrayList<>();

    @NotNull
    private Instant expirationDateTime;

}
