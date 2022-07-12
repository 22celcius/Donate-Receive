package com.gl.donate_receive.service.interfaces;

import com.gl.donate_receive.dto.ReportDto;
import com.gl.donate_receive.model.Item;
import com.gl.donate_receive.model.Report;

import java.util.List;

public interface ReportService {

	Report create(ReportDto reportDto);

	List<Report> getAll();

	Report getByItem(Item item);

}
