package io.rad.web.payload;

import lombok.*;

@Data
@Builder
public class JwtAuthenticationResponse {
    private final String accessToken;
    @Builder.Default private String tokenType = "Bearer";
}
