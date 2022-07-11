package com.gl.donate_receive.controller;

import com.gl.donate_receive.dto.ItemDto;
import com.gl.donate_receive.model.Item;
import com.gl.donate_receive.model.ItemType;
import com.gl.donate_receive.service.interfaces.ItemService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemController {

	private final ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@GetMapping
	public String getCreationForm(Model model) {
		model.addAttribute("item", new ItemDto());
		model.addAttribute("itemTypes", ItemType.values());
		return "create-item";
	}

	@PostMapping
	public String create(@Validated @ModelAttribute("item") ItemDto item) {
		itemService.create(item);
		return "redirect:/home";
	}

	@GetMapping("/{itemId}")
	@PreAuthorize("@authenticatedUserService.hasItem(#itemId)")
	public String getUpdatingForm(@PathVariable("itemId") String itemId, Model model) {
		Item item = itemService.getById(itemId);
		model.addAttribute("item", item);
		model.addAttribute("itemTypes", ItemType.values());
		return "update-item";
	}

	@PutMapping("/{itemId}")
	public String update(@PathVariable("itemId") String itemId,
	                     @Validated @ModelAttribute("item") ItemDto itemDto) {
		itemService.update(itemId, itemDto);
		return "redirect:/home";
	}

	@DeleteMapping("/{itemId}")
	@PreAuthorize("@authenticatedUserService.hasItem(#itemId)")
	public String delete(@PathVariable("itemId") String itemId) {
		itemService.delete(itemId);
		return "redirect:/home";
	}

	@GetMapping("/{itemId}/manage")
	public String getManagingForm(@PathVariable("itemId") String itemId, Model model) {
		Item item = itemService.getById(itemId);
		model.addAttribute("item", item);
		return "manage-item";
	}

}
