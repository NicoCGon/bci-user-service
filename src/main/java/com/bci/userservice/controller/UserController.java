package com.bci.userservice.controller;

import com.bci.userservice.model.dto.UserDto;
import com.bci.userservice.model.dto.UserResponseDto;
import com.bci.userservice.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid UserDto user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.userService.validateAndCreateUser(user));
    }
}
