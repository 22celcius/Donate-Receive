package com.gl.donate_receive.service;

import com.gl.donate_receive.model.User;
import com.gl.donate_receive.repository.UserRepository;
import com.gl.donate_receive.service.converter.UserConverter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthenticatedUserService implements UserDetailsService {
	private final UserRepository userRepository;
	private final UserConverter userConverter;

	public AuthenticatedUserService(UserRepository userRepository, UserConverter userConverter) {
		this.userRepository = userRepository;
		this.userConverter = userConverter;
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		return getByLogin(login);
	}

	public boolean hasItem(UUID id) {
		var login = SecurityContextHolder.getContext().getAuthentication().getName();
		var user = getByLogin(login);

		return user.getItems()
			.stream()
			.anyMatch(item -> item.getItemId().equals(id));

	}

	private User getByLogin(String login) {
		return userRepository.findByLogin(login)
			.orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}
}
