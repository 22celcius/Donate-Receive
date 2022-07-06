package com.gl.donate_receive.service;

import com.gl.donate_receive.dto.UserCreateDto;
import com.gl.donate_receive.model.User;
import com.gl.donate_receive.repository.UserRepository;
import com.gl.donate_receive.service.converter.UserConverter;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final UserConverter userConverter;

	public UserService(UserRepository userRepository, UserConverter userConverter) {
		this.userRepository = userRepository;
		this.userConverter = userConverter;
	}

	public User create(UserCreateDto userDto) {
		var user = userConverter.dtoToModel(userDto);
		return userRepository.save(user);
	}
}
