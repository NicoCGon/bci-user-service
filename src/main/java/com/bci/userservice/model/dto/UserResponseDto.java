package com.bci.userservice.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

	private String id;
	private String created;
	private String modified;
	private String lastLogin;
	private String token;
	private boolean isActive;
}
