package com.gl.donate_receive.donate_receive.repository;

import com.gl.donate_receive.donate_receive.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
}
