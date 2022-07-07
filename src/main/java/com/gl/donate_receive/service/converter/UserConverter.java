package com.gl.donate_receive.service.converter;

import com.gl.donate_receive.dto.UserCreateDto;
import com.gl.donate_receive.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

	public User dtoToModel(UserCreateDto userCreateDto) {
		return User.builder()
			.login(userCreateDto.getLogin())
			.password(userCreateDto.getPassword())
			.build();
	}
}

