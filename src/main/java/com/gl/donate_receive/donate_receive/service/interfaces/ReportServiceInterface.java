package com.gl.donate_receive.donate_receive.service.interfaces;

import com.gl.donate_receive.donate_receive.dto.ReportDto;
import com.gl.donate_receive.donate_receive.model.Report;
import java.util.List;

public interface ReportServiceInterface {

    Report create(ReportDto reportDto);

    List<Report> getAll();
}
