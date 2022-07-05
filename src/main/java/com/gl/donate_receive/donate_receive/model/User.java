package com.gl.donate_receive.donate_receive.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    private String role;
    private String login;

    @OneToMany(mappedBy = "ownerId")
    private List<Item> items;
}
