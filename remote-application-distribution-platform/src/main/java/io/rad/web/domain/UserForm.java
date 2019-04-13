package io.rad.web.domain;

import io.rad.web.documents.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserForm extends User {
    private final String matchingPassword;
}
