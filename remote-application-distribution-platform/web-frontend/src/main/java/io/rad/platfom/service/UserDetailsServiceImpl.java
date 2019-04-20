package io.rad.platfom.service;



import io.rad.platfom.domain.UserDocument;
import io.rad.platfom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<UserDocument> optional =  userRepository.findByUsername(userName);
		UserDocument user = optional.orElseThrow(() -> new UsernameNotFoundException("Email Not Found!!"));
		return user;
	}


}
