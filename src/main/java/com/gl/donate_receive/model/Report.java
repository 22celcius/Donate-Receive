package com.gl.donate_receive.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Report {
	@EmbeddedId
	private ReportId reportId;
	private String comment;
	@Lob
	private byte[] mediaFile;
}
