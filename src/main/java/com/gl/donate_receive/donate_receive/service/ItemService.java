package com.gl.donate_receive.donate_receive.service;

import com.gl.donate_receive.donate_receive.dto.ItemDto;
import com.gl.donate_receive.donate_receive.model.Item;
import com.gl.donate_receive.donate_receive.repository.ItemRepository;
import com.gl.donate_receive.donate_receive.service.converter.ItemConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;

@Service
public class ItemService {

	private final ItemRepository itemRepository;
	private final ItemConverter itemConverter;

	public ItemService(ItemRepository itemRepository, ItemConverter itemConverter) {
		this.itemRepository = itemRepository;
		this.itemConverter = itemConverter;
	}

	public Item create(ItemDto itemDto){
		var item = itemConverter.dtoToModel(itemDto);
		return itemRepository.save(item);
	}

	public Item getById(String itemId){
		return itemRepository.findById(UUID.fromString(itemId))
			.orElseThrow(() -> new EntityNotFoundException("Item with id: " + itemId + "not found"));
	}

	public Item update(String itemId, ItemDto itemDto){
		var item = itemConverter.dtoToModel(itemDto);
		item.setItemId(UUID.fromString(itemId));
		return itemRepository.save(item);
	}

	public void delete(String itemId){
		itemRepository.deleteById(UUID.fromString(itemId));
	}

	public List<Item> getAll() {
		return itemRepository.findAll();
	}

}
