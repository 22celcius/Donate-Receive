package com.gl.donate_receive.config;

import com.gl.donate_receive.service.AuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class WebAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private AuthenticatedUserService authenticatedUserService;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) {
		String login = authentication.getName();
		String password = authentication.getCredentials().toString();

		UserDetails userDetails = authenticatedUserService.loadUserByUsername(login);
		if (bCryptPasswordEncoder.matches(password, userDetails.getPassword())) {
			return new UsernamePasswordAuthenticationToken(
				userDetails.getUsername(),
				userDetails.getPassword(),
				userDetails.getAuthorities()
			);
		} else return null;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return true;
	}

}

