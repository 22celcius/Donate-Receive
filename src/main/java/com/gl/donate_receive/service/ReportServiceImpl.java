package com.gl.donate_receive.service;

import com.gl.donate_receive.dto.ReportDto;
import com.gl.donate_receive.model.Report;
import com.gl.donate_receive.repository.ReportRepository;
import com.gl.donate_receive.service.converter.ReportConverter;
import com.gl.donate_receive.service.interfaces.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

	private final ReportRepository reportRepository;
	private final ReportConverter reportConverter;

	@Override
	public Report create(ReportDto reportDto) {
		Report report = reportConverter.dtoToModel(reportDto);
		return reportRepository.save(report);
	}

	@Override
	public List<Report> getAll() {
		return reportRepository.findAll();
	}
}

