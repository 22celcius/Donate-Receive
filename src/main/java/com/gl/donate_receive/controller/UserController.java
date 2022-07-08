package com.gl.donate_receive.controller;

import com.gl.donate_receive.dto.UserDto;
import com.gl.donate_receive.service.interfaces.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public String getCreationForm(Model model) {
		model.addAttribute("user", new UserDto());
		return "create-user";
	}

	@PostMapping
	public String create(@Valid @ModelAttribute("user") UserDto user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "create-user";
		}
		var createdUser = userService.create(user);
		model.addAttribute("userId", createdUser.getUserId());
		return "redirect:form-login";
	}

}
