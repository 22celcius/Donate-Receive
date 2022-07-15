package com.gl.donate_receive.service;

import com.gl.donate_receive.dto.FullItemDto;
import com.gl.donate_receive.dto.ItemDto;
import com.gl.donate_receive.model.Item;
import com.gl.donate_receive.repository.ItemRepository;
import com.gl.donate_receive.service.converter.ItemConverter;
import com.gl.donate_receive.service.interfaces.ItemService;
import com.gl.donate_receive.service.interfaces.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

	private final AuthenticatedUserService authenticatedUserService;
	private final ItemRepository itemRepository;
	private final ItemConverter itemConverter;
	private final ReportService reportService;

	@Override
	public Item create(ItemDto itemDto) {
		var ownerId = authenticatedUserService.getOwnerId();
		var item = itemConverter.dtoToModel(itemDto, ownerId);
		return itemRepository.save(item);
	}

	@Override
	public Item getById(UUID itemId) {
		return itemRepository.findById(itemId)
			.orElseThrow(() -> new EntityNotFoundException("Item with id: " + itemId + " not found"));
	}

	@Override
	public Item update(UUID itemId, FullItemDto fullItemDto) {
		var oldItem = getById(itemId);
		oldItem.setName(fullItemDto.getName());
		oldItem.setDescription(fullItemDto.getDescription());
		oldItem.setType(fullItemDto.getType());

		reportService.updateComment(oldItem, fullItemDto.getComment());

		return itemRepository.save(oldItem);
	}

	@Override
	public void delete(String itemId) {
		itemRepository.deleteById(UUID.fromString(itemId));
	}

	@Override
	public List<Item> getAll() {
		return itemRepository.findAll();
	}

}
