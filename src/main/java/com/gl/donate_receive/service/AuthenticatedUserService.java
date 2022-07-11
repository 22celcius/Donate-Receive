package com.gl.donate_receive.service;

import com.gl.donate_receive.model.User;
import com.gl.donate_receive.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthenticatedUserService implements UserDetailsService {
	private final UserRepository userRepository;

	public AuthenticatedUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		return getByLogin(login);
	}

	public boolean hasItem(UUID id) {
		if (id == null) return false;

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
