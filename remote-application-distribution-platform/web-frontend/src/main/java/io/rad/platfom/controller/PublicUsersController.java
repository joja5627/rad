package io.rad.platfom.controller;

import io.rad.platfom.service.UserAuthenticationService;
import io.rad.platfom.domain.UserDocument;
import io.rad.platfom.service.UserCrudService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/public/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
final class PublicUsersController {
  @NonNull
  UserAuthenticationService authentication;
  @NonNull
  UserCrudService users;

  @PostMapping("/register")
  String register(
    @RequestParam("username") final String username,
    @RequestParam("password") final String password) {
    users
      .save(
        UserDocument
          .builder()
          .id(username)
          .username(username)
          .password(password)
          .build()
      );

    return login(username, password);
  }
  	@RequestMapping("/login")
	public ModelAndView loginPage(){
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		System.out.println("--->"+ SecurityContextHolder.getContext().getAuthentication().getName());
		return model;
	}
  @PostMapping("/login")
  String login(
    @RequestParam("username") final String username,
    @RequestParam("password") final String password) {
    return authentication
      .login(username, password)
      .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
  }
}
