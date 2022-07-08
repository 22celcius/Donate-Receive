package com.gl.donate_receive.service.interfaces;

import com.gl.donate_receive.dto.ItemDto;
import com.gl.donate_receive.model.Item;
import java.util.List;

public interface ItemService {

    Item create(ItemDto itemDto);

    Item getById(String itemId);

    Item update(String itemId, ItemDto itemDto);

    void delete(String itemId);

    List<Item> getAll();
}
