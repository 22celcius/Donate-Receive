package com.gl.donate_receive.service.converter;


import com.gl.donate_receive.dto.UserDto;
import com.gl.donate_receive.model.Role;
import com.gl.donate_receive.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserConverter {

	private final PasswordEncoder passwordEncoder;

	public User dtoToModel(UserDto userDto) {
		return User.builder()
			.login(userDto.getLogin())
			.password(passwordEncoder.encode(userDto.getPassword()))
			.role(getRole(userDto.getRole()))
			.build();
	}

	private Role getRole(Role role) {
		return role == null ? Role.USER : role;
	}

}

