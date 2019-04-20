package io.rad.platfom.domain;

import lombok.*;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Document
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDocument implements UserDetails{

    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private String username;
    private String password;
    private String email;

    @Builder.Default
    private Set<GrantedAuthority> authorities = new HashSet<>(Arrays.asList(new SimpleGrantedAuthority("USER")));
    @Builder.Default
    private boolean accountNonExpired = true;
    @Builder.Default
    private boolean accountNonLocked = true;
    @Builder.Default
    private boolean credentialsNonExpired = true;
    @Builder.Default
    private boolean enabled = true;
}
