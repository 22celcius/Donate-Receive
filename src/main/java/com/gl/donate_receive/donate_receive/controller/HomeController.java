package com.gl.donate_receive.donate_receive.controller;

import com.gl.donate_receive.donate_receive.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	private final ItemService itemService;

	public HomeController(ItemService itemService) {
		this.itemService = itemService;
	}

	@GetMapping({"/", "home"})
	public String home(Model model) {
		model.addAttribute("items", itemService.getAll());
		return "home";
	}

}
