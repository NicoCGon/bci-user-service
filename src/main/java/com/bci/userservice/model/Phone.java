package com.bci.userservice.model;

import jakarta.persistence.*;
import lombok.*;

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
@Table(name = "phones")
public class Phone {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private UUID id;
	private UUID userId;

	private String number;
	private String cityCode;
	private String countryCode;

	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
}
