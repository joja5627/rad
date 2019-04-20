package io.rad.platfom.controller;


import io.rad.platfom.service.UserAuthenticationService;
import io.rad.platfom.domain.UserDocument;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
final class SecuredUsersController {
  @NonNull
  UserAuthenticationService authentication;

  @GetMapping("/current")
  UserDocument getCurrent(@AuthenticationPrincipal final UserDocument user) {
    return user;
  }

  @GetMapping("/logout")
  boolean logout(@AuthenticationPrincipal final UserDocument user) {
    authentication.logout(user);
    return true;
  }
}
