package com.gl.donate_receive.service;

import com.gl.donate_receive.dto.ReportDto;
import com.gl.donate_receive.model.Item;
import com.gl.donate_receive.model.Report;
import com.gl.donate_receive.model.ReportId;
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
	private final AuthenticatedUserService authenticatedUserService;

	@Override
	public Report create(ReportDto reportDto) {
//		TODO clarify whether we need to check the rights to create reports here
		var report = reportConverter.dtoToModel(reportDto);
		var ownerId = authenticatedUserService.getOwnerId();
		report.getReportId().setReceiverId(ownerId);

		return reportRepository.save(report);
	}

	@Override
	public List<Report> getAll() {
		return reportRepository.findAll();
	}

	@Override
	public Report getByItem(Item item) {
		var reportId = new ReportId();
		reportId.setItemId(item.getItemId());
		reportId.setReceiverId(item.getOwnerId());

//		TODO consider on changing returning logic
		return reportRepository.getByReportId(reportId).orElse(new Report());
	}

}
