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
		var reportId = getReportId(reportDto.getReceiverId(), reportDto.getReceiverId());
		return Report.builder()
			.comment(reportDto.getComment())
			.reportId(reportId)
			.mediaFile(convertMediaFileToBytesArray(reportDto.getFile()))
			.build();
	}

	private ReportId getReportId(String itemId, String receiverId) {
		var reportId = new ReportId();
		reportId.setItemId(UUID.fromString(itemId));
		reportId.setReceiverId(UUID.fromString(receiverId));
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
