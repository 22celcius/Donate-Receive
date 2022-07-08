package com.gl.donate_receive.controller;

import com.gl.donate_receive.dto.UserDto;
import com.gl.donate_receive.model.User;
import com.gl.donate_receive.service.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<User> create(@RequestBody UserDto user) {
		final User createdUser = userService.create(user);
		return new ResponseEntity<>(createdUser, HttpStatus.OK);
	}


}