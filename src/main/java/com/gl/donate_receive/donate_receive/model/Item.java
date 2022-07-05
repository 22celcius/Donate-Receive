package com.gl.donate_receive.donate_receive.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
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
