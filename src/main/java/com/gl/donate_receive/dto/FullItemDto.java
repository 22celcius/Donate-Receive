package com.gl.donate_receive.dto;

import com.gl.donate_receive.model.ItemType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FullItemDto {

	private String name;
	private String description;
	private ItemType type;
	private UUID ownerId;
	private String comment;

}
