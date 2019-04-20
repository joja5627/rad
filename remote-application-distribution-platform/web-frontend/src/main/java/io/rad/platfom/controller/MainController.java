//package io.rad.platfom.controller;
//
//import io.rad.platfom.domain.LoginRequest;
//import net.davidtanzer.jdefensive.Returns;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//
//
//@RequestMapping("/api/v1")
//@RestController
//public class MainController {
//

//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public Authentication login(@RequestBody LoginRequest userRequest) {
//		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));
//		boolean isAuthenticated = isAuthenticated(authentication);
//		if (isAuthenticated) {
//			SecurityContextHolder.getContext().setAuthentication(authentication);
//		}
//		return authentication;
//	}
//
//	private boolean isAuthenticated(Authentication authentication) {
//		return authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
//	}
//
//	@RequestMapping(value = "/secured/loginSuccess", method = RequestMethod.POST)
//	public ResponseEntity loginSuccess(){
//		return ResponseEntity.ok("ok");
//	}
//
//	@PreAuthorize("hasAnyRole('ADMIN')")
//	@RequestMapping("/secured/home")
//	public String homePage(){
//		System.out.println("/secured/home");
//		return "home";
//	}
//
//	@PreAuthorize("hasAnyRole('USER')")
//	@RequestMapping("/secured/user")
//	public String userPage(){
//		System.out.println("/secured/user");
//		return "user page";
//	}
//
//	@RequestMapping("/noLogin")
//	public String noLogin(){
//		return "user page";
//	}
//}
//
//
