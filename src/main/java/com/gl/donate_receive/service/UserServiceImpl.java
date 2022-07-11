package com.gl.donate_receive.service;

import com.gl.donate_receive.dto.UserDto;
import com.gl.donate_receive.model.Role;
import com.gl.donate_receive.model.User;
import com.gl.donate_receive.repository.UserRepository;
import com.gl.donate_receive.service.converter.UserConverter;
import com.gl.donate_receive.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserConverter userConverter;

	@Override
	public User create(UserDto userDto) {
		User user = userConverter.dtoToModel(userDto);
		verifyUserRole(user);
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

	private void verifyUserRole(User user) {
		if (user.getRole() == null) {
			user.setRole(Role.USER);
		}
	}

}
