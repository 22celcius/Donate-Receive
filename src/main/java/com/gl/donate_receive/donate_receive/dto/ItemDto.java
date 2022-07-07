package com.gl.donate_receive.donate_receive.dto;

import com.gl.donate_receive.donate_receive.model.ItemType;
import lombok.Data;
import java.util.UUID;

@Data
public class ItemDto {
	private String name;
	private String description;
	private ItemType type;
	private UUID ownerId;
}

