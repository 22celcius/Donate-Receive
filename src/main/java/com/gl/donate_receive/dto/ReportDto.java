package com.gl.donate_receive.dto;

import com.gl.donate_receive.validator.annotation.ValidFile;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Data
public class ReportDto {

	private UUID itemId;
	private UUID receiverId;
	private String comment;
	@ValidFile
	private MultipartFile file;

}
