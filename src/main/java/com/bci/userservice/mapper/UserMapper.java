package com.bci.userservice.mapper;

import com.bci.userservice.model.User;
import com.bci.userservice.model.dto.UserDto;
import com.bci.userservice.model.dto.UserResponseDto;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;

public class UserMapper {

    public static User mapToUser(UserDto userDto){
        LocalDateTime now = LocalDateTime.now();
        UUID userId = UUID.randomUUID();

        return User.builder()
                .id(userId)
                .email(userDto.getEmail())
                .name(userDto.getName())
                .password(Base64.getEncoder().encodeToString(userDto.getPassword().getBytes()))
                .createdAt(now)
                .modifiedAt(now)
                .lastLoginAt(now)
                .isActive(Boolean.TRUE)
                .token(userId.toString())
                .build();
    }

    public static UserResponseDto mapToUserResponseDto(User user){
        return UserResponseDto.builder()
                .id(user.getId().toString())
                .created(user.getCreatedAt().toString())
                .modified(user.getModifiedAt().toString())
                .lastLogin(user.getLastLoginAt().toString())
                .token(user.getToken())
                .isActive(user.isActive())
                .build();
    }
}
