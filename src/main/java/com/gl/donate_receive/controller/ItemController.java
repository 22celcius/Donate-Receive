package com.gl.donate_receive.controller;

import com.gl.donate_receive.dto.FullItemDto;
import com.gl.donate_receive.dto.ItemDto;
import com.gl.donate_receive.model.Item;
import com.gl.donate_receive.model.ItemStatus;
import com.gl.donate_receive.model.ItemType;
import com.gl.donate_receive.model.Report;
import com.gl.donate_receive.service.converter.ItemConverter;
import com.gl.donate_receive.service.interfaces.ItemService;
import com.gl.donate_receive.service.interfaces.ReportService;
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

import java.util.Base64;
import java.util.UUID;

@Controller
@RequestMapping("/items")
public class ItemController {

	private final ItemService itemService;
	private final ReportService reportService;
	private final ItemConverter itemConverter;

	public ItemController(ItemService itemService, ReportService reportService, ItemConverter itemConverter) {
		this.itemService = itemService;
		this.reportService = reportService;
		this.itemConverter = itemConverter;
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
	public String getUpdatingForm(@PathVariable("itemId") UUID itemId, Model model) {
		var item = itemService.getById(itemId);
		var report = checkAndGetReport(item);
		var fullItemDto = itemConverter.modelsToDto(item, report);
		model.addAttribute("fullItem", fullItemDto);
		model.addAttribute("itemTypes", ItemType.values());

		return "update-item";
	}

	@PutMapping("/{itemId}")
	public String update(@PathVariable("itemId") UUID itemId,
	                     @ModelAttribute("item") FullItemDto fullItemDto
	) {
		itemService.update(itemId, fullItemDto);
		return "redirect:/home";
	}

	@DeleteMapping("/{itemId}")
	@PreAuthorize("@authenticatedUserService.hasItem(#itemId)")
	public String delete(@PathVariable("itemId") String itemId) {
		itemService.delete(itemId);
		return "redirect:/home";
	}

	@GetMapping("/{itemId}/manage")
	public String getManagingForm(@PathVariable("itemId") UUID itemId, Model model) {
		Item item = itemService.getById(itemId);
		model.addAttribute("item", item);
		return "manage-item";
	}

	@GetMapping("/{itemId}/info")
	public String getById(@PathVariable("itemId") UUID itemId, Model model) {
		var item = itemService.getById(itemId);
		var report = checkAndGetReport(item);
		var fullItemDto = itemConverter.modelsToDto(item, report);
		model.addAttribute("fullItem", fullItemDto);
		if (report != null && report.getMediaFile().length != 0) {
			model.addAttribute("file", Base64.getEncoder().encodeToString(report.getMediaFile()));
		}

		return "item-info";
	}

	private Report checkAndGetReport(Item item) {
		var report = new Report();
		if (ItemStatus.DELIVERED.equals(item.getStatus())) {
			report = reportService.getByItem(item);
		}

		return report;
	}

}
