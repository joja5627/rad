package io.rad.platfom.service;


import com.google.common.collect.ImmutableMap;
import io.rad.platfom.domain.UserDocument;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Service

@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
final class TokenAuthenticationService implements UserAuthenticationService {
  @NonNull
  TokenService tokens;
  @NonNull
  UserCrudService users;

  @Override
  public Optional<String> login(final String username, final String password) {
    return users
      .findByUsername(username)
      .filter(user -> Objects.equals(password, user.getPassword()))
      .map(user -> tokens.expiring(ImmutableMap.of("username", username)));
  }

  @Override
  public Optional<UserDocument> findByToken(final String token) {
    return Optional
      .of(tokens.verify(token))
      .map(map -> map.get("username"))
      .flatMap(users::findByUsername);
  }

  @Override
  public void logout(final UserDocument user) {
    // Nothing to doy
  }
}
