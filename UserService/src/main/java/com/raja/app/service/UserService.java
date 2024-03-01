package com.raja.app.service;

import com.raja.app.dto.UserDto;

import java.util.List;

public interface UserService {

    public List<UserDto> getAllUsers();

    public UserDto createUser(UserDto userDto);

    public UserDto updateUser(UserDto userDto);

    public void deteleUser(Long userId);

    public UserDto getUser(Long id);
}
