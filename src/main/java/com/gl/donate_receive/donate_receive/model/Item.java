package com.gl.donate_receive.donate_receive.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID itemID;
	private String name;
	private String description;
	private String type;
	private String status;
	private UUID ownerId;

}
