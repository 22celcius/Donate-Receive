package com.gl.donate_receive.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ReportDto {

	private String itemId;
	private String receiverId;
	private String comment;
	private MultipartFile file;

}
