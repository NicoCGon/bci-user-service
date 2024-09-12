package com.bci.userservice.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;



@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto{

	@NotBlank(message = "El nombre es obligatorio")
	@Length(min = 0, max = 100, message = "El nombre debe tener entre 0 y 100 caracteres")
	private String name;

	@Length(min = 0, max = 50, message = "El email debe tener entre 0 y 50 caracteres")
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.cl+$", message = "El email debe tener un formato correcto", flags = Pattern.Flag.MULTILINE)
	private String email;

	@NotBlank(message = "La contraseña es obligatoria")
	@Length(min = 0, max = 128, message = "La contraseña debe tener entre 0 y 128 caracteres")
	private String password;

	private List<PhoneDto> phones;


}
