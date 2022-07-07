package com.gl.donate_receive.controller;

import com.gl.donate_receive.dto.UserDto;
import com.gl.donate_receive.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public String create(Model model) {
		model.addAttribute("user", new UserDto());
		return "create-user";
	}

	@PostMapping
	public String create(@Validated @ModelAttribute("user") UserDto user, Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "create-user";
		}
		var createdUser = userService.create(user);
		model.addAttribute("userId", createdUser.getUserId());
		return "redirect:home";
	}
}
