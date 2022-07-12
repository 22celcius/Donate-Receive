package com.gl.donate_receive.service;

import com.gl.donate_receive.dto.ItemDto;
import com.gl.donate_receive.model.Item;
import com.gl.donate_receive.repository.ItemRepository;
import com.gl.donate_receive.service.converter.ItemConverter;
import com.gl.donate_receive.service.interfaces.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

	private final ItemRepository itemRepository;
	private final AuthenticatedUserService authenticatedUserService;
	private final ItemConverter itemConverter;

	@Override
	public Item create(ItemDto itemDto) {
		var ownerId = authenticatedUserService.getOwnerId();
		var item = itemConverter.dtoToModel(itemDto, ownerId);
		return itemRepository.save(item);
	}

	@Override
	public Item getById(String itemId) {
		return itemRepository.findById(UUID.fromString(itemId))
			.orElseThrow(() -> new EntityNotFoundException("Item with id: " + itemId + " not found"));
	}

	@Override
	public Item update(String itemId, ItemDto itemDto) {
		var ownerId = authenticatedUserService.getOwnerId();
		var item = itemConverter.dtoToModel(itemDto, ownerId);
		item.setItemId(UUID.fromString(itemId));
		return itemRepository.save(item);
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
