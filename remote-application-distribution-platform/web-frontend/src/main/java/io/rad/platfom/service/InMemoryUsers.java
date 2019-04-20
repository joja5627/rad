package io.rad.platfom.service;

import io.rad.platfom.domain.UserDocument;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
final class InMemoryUsers implements UserCrudService {

  Map<String, UserDocument> users = new HashMap<>();

  @Override
  public UserDocument save(final UserDocument user) {
    return users.put(user.getId(), user);
  }

  @Override
  public Optional<UserDocument> find(final String id) {
    return ofNullable(users.get(id));
  }

  @Override
  public Optional<UserDocument> findByUsername(final String username) {
    return users
      .values()
      .stream()
      .filter(u -> Objects.equals(username, u.getUsername()))
      .findFirst();
  }
}
