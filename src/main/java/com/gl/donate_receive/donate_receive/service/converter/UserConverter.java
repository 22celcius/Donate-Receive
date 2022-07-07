package com.gl.donate_receive.donate_receive.service.converter;

import com.gl.donate_receive.donate_receive.dto.UserDto;
import com.gl.donate_receive.donate_receive.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

	public User dtoToModel(UserDto userCreateDto) {
		return User.builder()
			.login(userCreateDto.getLogin())
			.password(userCreateDto.getPassword())
			.build();
	}
}

