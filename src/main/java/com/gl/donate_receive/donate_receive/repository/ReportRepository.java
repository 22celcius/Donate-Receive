package com.gl.donate_receive.donate_receive.repository;

import com.gl.donate_receive.donate_receive.model.Report;
import com.gl.donate_receive.donate_receive.model.ReportId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, ReportId> {
}
