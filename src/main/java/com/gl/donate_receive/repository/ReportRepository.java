package com.gl.donate_receive.repository;

import com.gl.donate_receive.model.Report;
import com.gl.donate_receive.model.ReportId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, ReportId> {

	@Transactional
	Optional<Report> getByReportId(ReportId reportId);

}
