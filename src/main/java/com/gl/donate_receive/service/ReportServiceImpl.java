package com.gl.donate_receive.service;

import com.gl.donate_receive.dto.ReportDto;
import com.gl.donate_receive.model.Item;
import com.gl.donate_receive.model.Report;
import com.gl.donate_receive.model.ReportId;
import com.gl.donate_receive.repository.ReportRepository;
import com.gl.donate_receive.service.converter.ReportConverter;
import com.gl.donate_receive.service.interfaces.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

	private final AuthenticatedUserService authenticatedUserService;
	private final ReportRepository reportRepository;
	private final ReportConverter reportConverter;

	@Override
	public Report create(ReportDto reportDto) {
		checkCreateRights(reportDto.getReceiverId());
		var report = reportConverter.dtoToModel(reportDto);

		return reportRepository.save(report);
	}

	@Override
	public Report getByItem(Item item) {
		var reportId = new ReportId();
		reportId.setItemId(item.getItemId());
		reportId.setReceiverId(item.getReceiverId());

//		TODO consider on changing returning logic
		return reportRepository.getByReportId(reportId).orElse(new Report());
	}

	@Override
	public Report updateComment(Item item, String comment) {
		var oldReport = getByItem(item);
		oldReport.setComment(comment);

		return reportRepository.save(oldReport);
	}

	@Override
	public List<Report> getAll() {
		return reportRepository.findAll();
	}


	private void checkCreateRights(UUID receiverId) {
		var ownerId = authenticatedUserService.getOwnerId();

		if (!receiverId.equals(ownerId)) {
			throw new AccessDeniedException("You can't create report to this item");
		}
	}

}
