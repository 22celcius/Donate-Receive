package com.gl.donate_receive.service.converter;

import com.gl.donate_receive.dto.ItemDto;
import com.gl.donate_receive.model.Item;
import com.gl.donate_receive.model.ItemStatus;
import com.gl.donate_receive.model.ItemType;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ItemConverter {

	public Item dtoToModel(ItemDto itemDto, UUID ownerId) {
		return Item.builder()
			.name(itemDto.getName())
			.description(itemDto.getDescription())
			.type(itemDto.getType())
			.status(getStatus(itemDto))
			.ownerId(ownerId)
			.build();
	}

	private ItemStatus getStatus(ItemDto itemDto) {
		return itemDto.getType().equals(ItemType.AVAILABLE) ?
			ItemStatus.RECEIVABLE : ItemStatus.DONATABLE;
	}

}
