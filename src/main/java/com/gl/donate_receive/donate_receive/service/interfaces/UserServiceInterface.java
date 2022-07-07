package com.gl.donate_receive.donate_receive.service.interfaces;

import com.gl.donate_receive.donate_receive.dto.UserDto;
import com.gl.donate_receive.donate_receive.model.User;
import java.util.List;

public interface UserServiceInterface {

    User create(UserDto userDto);

    User getById(String userId);

    User update(String userId, UserDto userDto);

    void delete(String userId);

    List<User> getAll();
}
