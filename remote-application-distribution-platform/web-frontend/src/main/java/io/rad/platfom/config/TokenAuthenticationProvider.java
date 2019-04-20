package io.rad.platfom.config;

import io.rad.platfom.service.UserAuthenticationService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Slf4j
@Component
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
final class TokenAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
  @NonNull
  UserAuthenticationService auth;

  @Override
  protected void additionalAuthenticationChecks(final UserDetails d, final UsernamePasswordAuthenticationToken auth) {
    // Nothing to do
    log.info(d.toString());
    log.info(auth.toString());
  }

  @Override
  protected UserDetails retrieveUser(final String username, final UsernamePasswordAuthenticationToken authentication) {
    final Object token = authentication.getCredentials();
    return Optional
      .ofNullable(token)
      .map(String::valueOf)
      .flatMap(auth::findByToken)
      .orElseThrow(() -> new UsernameNotFoundException("Cannot find user with authentication token=" + token));
  }
}