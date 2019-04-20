package io.rad.platfom.service;

import io.rad.platfom.domain.UserDocument;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Service
@Profile("token")
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
final class UUIDAuthenticationService implements UserAuthenticationService {
  @NonNull
  UserCrudService users;

  @Override
  public Optional<String> login(final String username, final String password) {
    final String uuid = UUID.randomUUID().toString();
    final UserDocument user = UserDocument
      .builder()
      .id(uuid)
      .username(username)
      .password(password)
      .build();

    users.save(user);
    return Optional.of(uuid);
  }

  @Override
  public Optional<UserDocument> findByToken(final String token) {
    return users.find(token);
  }

  @Override
  public void logout(final UserDocument user) {

  }
}

