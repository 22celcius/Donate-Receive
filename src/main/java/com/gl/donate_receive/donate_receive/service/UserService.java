package com.gl.donate_receive.donate_receive.service;

import com.gl.donate_receive.donate_receive.dto.UserDto;
import com.gl.donate_receive.donate_receive.model.User;
import com.gl.donate_receive.donate_receive.repository.UserRepository;
import com.gl.donate_receive.donate_receive.service.converter.UserConverter;
import com.gl.donate_receive.donate_receive.service.interfaces.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {

	private final UserRepository userRepository;
	private final UserConverter userConverter;

	@Override
	public User create(UserDto userDto) {
		User user = userConverter.dtoToModel(userDto);
		return userRepository.save(user);
	}

	@Override
	public User getById(String userId) {
		return userRepository.findById(UUID.fromString(userId))
				.orElseThrow(() -> new EntityNotFoundException("User with id: " + userId + " not found"));
	}

	@Override
	public User update(String userId, UserDto userDto){
		User user = userConverter.dtoToModel(userDto);
		user.setUserId(UUID.fromString(userId));
		return userRepository.save(user);
	}

	@Override
	public void delete(String userId) {
		userRepository.deleteById(UUID.fromString(userId));
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}
}

