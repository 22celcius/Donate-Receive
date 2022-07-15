package com.gl.donate_receive.service.converter;

import com.gl.donate_receive.dto.FullItemDto;
import com.gl.donate_receive.dto.ItemDto;
import com.gl.donate_receive.model.Item;
import com.gl.donate_receive.model.ItemStatus;
import com.gl.donate_receive.model.ItemType;
import com.gl.donate_receive.model.Report;
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

	public FullItemDto modelsToDto(Item item, Report report) {
		var fullItemDtoBuilder = FullItemDto.builder()
			.name(item.getName())
			.description(item.getDescription())
			.type(item.getType())
			.ownerId(item.getOwnerId());

		if (report != null) {
			fullItemDtoBuilder.comment(report.getComment());
		}

		return fullItemDtoBuilder.build();
	}

	private ItemStatus getStatus(ItemDto itemDto) {
		return ItemType.AVAILABLE.equals(itemDto.getType()) ?
			ItemStatus.RECEIVABLE : ItemStatus.DONATABLE;
	}

}
