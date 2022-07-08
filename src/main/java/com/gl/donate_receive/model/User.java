package com.gl.donate_receive.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID userId;
	@Enumerated(EnumType.STRING)
	private Role role;
	@NotNull
	@Size(max = 320)
	@Column(unique = true)
	private String login;
	@NotNull
	@Size(max = 128)
	private String password;
	@OneToMany(mappedBy = "ownerId")
	private List<Item> items;
}
