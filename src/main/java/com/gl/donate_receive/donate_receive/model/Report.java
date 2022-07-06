package com.gl.donate_receive.donate_receive.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
@Data
@Builder
public class Report {
	@EmbeddedId
	private ReportId reportId;
	private String comment;
	@Lob
	private byte[] mediaType;
}

