package com.bci.userservice.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDto {

	@NotBlank(message = "El número es obligatorio")
	private String number;

	@NotBlank(message = "El código de la ciudad es obligatorio")
	private String citycode;

	@NotBlank(message = "El código del pais es obligatorio")
	private String contrycode;
}
