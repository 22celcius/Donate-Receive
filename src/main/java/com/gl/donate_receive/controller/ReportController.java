package com.gl.donate_receive.controller;

import com.gl.donate_receive.dto.ReportDto;
import com.gl.donate_receive.service.interfaces.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports")
public class ReportController {

	private final ReportService reportService;

	public ReportController(ReportService reportService) {
		this.reportService = reportService;
	}

	@GetMapping("/{itemId}")
	public String getCreationForm(@PathVariable String itemId, Model model) {
		var reportDto = new ReportDto();
		reportDto.setItemId(itemId);
		model.addAttribute("report", reportDto);
		return "create-report";
	}

	@PostMapping
	public String create(@ModelAttribute("report") ReportDto report) {
		reportService.create(report);
		return "redirect:/home";
	}

}
