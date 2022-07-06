package com.gl.donate_receive.donate_receive.service;

import com.gl.donate_receive.donate_receive.repository.ReportRepository;
import org.springframework.stereotype.Component;

@Component
public class ReportService {

	private ReportRepository reportRepository;

	public ReportService(ReportRepository reportRepository) {
		this.reportRepository = reportRepository;
	}

}
