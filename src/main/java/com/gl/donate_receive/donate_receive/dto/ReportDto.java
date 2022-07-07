package com.gl.donate_receive.donate_receive.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class ReportDto {
	private UUID itemId;
	private UUID receiverId;
	private String comment;
	private byte[] mediaFile;
}

