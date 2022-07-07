package com.gl.donate_receive.donate_receive.service.converter;

import com.gl.donate_receive.donate_receive.dto.ReportDto;
import com.gl.donate_receive.donate_receive.model.Report;

public class ReportConverter {

    public Report dtoToModel(ReportDto reportDto) {
        return Report.builder()
                .comment(reportDto.getComment())
                .mediaFile(reportDto.getMediaFile())
                .build();
    }
}
