package com.gl.donate_receive.service.converter;

import com.gl.donate_receive.dto.ReportDto;
import com.gl.donate_receive.model.Report;
import com.gl.donate_receive.model.ReportId;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Component
public class ReportConverter {

	public Report dtoToModel(ReportDto reportDto) {
		var reportId = getReportId(reportDto.getItemId(), reportDto.getReceiverId());
		return Report.builder()
			.reportId(reportId)
			.comment(reportDto.getComment())
			.mediaFile(convertMediaFileToBytesArray(reportDto.getFile()))
			.build();
	}

	private ReportId getReportId(UUID itemId, UUID receiverId) {
		var reportId = new ReportId();
		reportId.setItemId(itemId);
		reportId.setReceiverId(receiverId);
		return reportId;
	}

	private byte[] convertMediaFileToBytesArray(MultipartFile file) {
		if (file == null) {
			return new byte[0];
		}

		final byte[] mediaFile;
		try {
			mediaFile = file.getBytes();
		} catch (IOException e) {
			throw new IllegalArgumentException("Cannot parse received file");
		}

		return mediaFile;
	}

}
