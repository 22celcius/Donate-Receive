package com.gl.donate_receive.service.interfaces;

import com.gl.donate_receive.dto.FullItemDto;
import com.gl.donate_receive.dto.ItemDto;
import com.gl.donate_receive.model.Item;
import java.util.List;
import java.util.UUID;

public interface ItemService {

    Item create(ItemDto itemDto);

    Item getById(UUID itemId);

    Item update(UUID itemId, FullItemDto itemDto);

    void delete(String itemId);

    List<Item> getAll();
}
