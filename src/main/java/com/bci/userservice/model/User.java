package com.bci.userservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 
 * @author  ngonzalez
 */

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

	@Id
	private UUID id;
	private String name;
	private String email;
	private String password;
	private boolean isActive;
	private String token;

	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	private LocalDateTime lastLoginAt;

}
