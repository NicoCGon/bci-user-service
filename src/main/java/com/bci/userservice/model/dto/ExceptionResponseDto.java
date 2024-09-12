package com.bci.userservice.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponseDto {

	@JsonProperty("mensaje")
	private String message;
}
