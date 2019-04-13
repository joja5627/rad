package io.rad.web.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "password-reset-tokens")public class Privilege {

    @Id
    private Long id;
    private String name;
    private Collection<Role> roles;

}
