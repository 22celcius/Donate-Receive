package com.gl.donate_receive.dto;

import com.gl.donate_receive.model.Role;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDto {
	@NotNull
	@Size(max = 320)
	private String login;
	@NotNull
	@Size(max = 128)
	private String password;
	private Role role;

}
