package com.bci.userservice.service.impl;

import com.bci.userservice.mapper.UserMapper;
import com.bci.userservice.model.User;
import com.bci.userservice.model.dto.UserDto;
import com.bci.userservice.model.dto.UserResponseDto;
import com.bci.userservice.repository.UserRepository;
import com.bci.userservice.service.IPhoneService;
import com.bci.userservice.service.IUserService;
import com.bci.userservice.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final UserValidator userValidator;
    private final IPhoneService phoneService;

    public UserResponseDto validateAndCreateUser(UserDto userDto) {
        this.userValidator.validateUser(userDto);

        User user = this.userRepository.save(UserMapper.mapToUser(userDto));
        this.phoneService.create(userDto.getPhones(), user.getId());

        return UserMapper.mapToUserResponseDto(user);
    }

}
