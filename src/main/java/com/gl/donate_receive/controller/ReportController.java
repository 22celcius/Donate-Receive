package com.gl.donate_receive.controller;

import com.gl.donate_receive.dto.ReportDto;
import com.gl.donate_receive.service.interfaces.ReportService;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;
import javax.validation.Valid;

@Controller
@RequestMapping("/reports")
public class ReportController {

	private final ReportService reportService;

	public ReportController(ReportService reportService) {
		this.reportService = reportService;
	}

	@GetMapping("/{itemId}")
	public String getCreationForm(@PathVariable UUID itemId, @RequestParam("receiverId") @Nullable UUID receiverId, Model model) {
		var reportDto = new ReportDto();
		reportDto.setItemId(itemId);
		reportDto.setReceiverId(receiverId);
		model.addAttribute("report", reportDto);

		return "create-report";
	}

	@PostMapping
	public String create(@Valid @ModelAttribute("report") ReportDto report, BindingResult result) {
		if (result.hasErrors()) {
			return "create-report";
		}

		reportService.create(report);

		return "redirect:/home";
	}

}
