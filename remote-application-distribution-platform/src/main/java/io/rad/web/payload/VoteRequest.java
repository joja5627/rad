package io.rad.web.payload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoteRequest {
    @NotNull
    private Long choiceId;
}

