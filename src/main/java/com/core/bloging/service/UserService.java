package com.core.bloging.service;

import com.core.bloging.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto updateById(UserDto userDto,Integer id);
    UserDto getById(Integer id);
    List<UserDto> getAll();
    void deleteById(Integer id);
}
