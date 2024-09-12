package com.bci.userservice.service;

import com.bci.userservice.model.dto.UserDto;
import com.bci.userservice.model.dto.UserResponseDto;

public interface IUserService {

    UserResponseDto validateAndCreateUser(UserDto userDto);
}
