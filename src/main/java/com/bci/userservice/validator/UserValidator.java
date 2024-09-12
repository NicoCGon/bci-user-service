package com.bci.userservice.validator;

import com.bci.userservice.exception.BCIException;
import com.bci.userservice.model.dto.PhoneDto;
import com.bci.userservice.model.dto.UserDto;
import com.bci.userservice.repository.UserRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidator {

    private final UserRepository userRepository;
    private final String passwordRegexPattern;

    public UserValidator(UserRepository userRepository, @Value("${config.password-regex}") String passwordRegexPattern) {
        this.userRepository = userRepository;
        this.passwordRegexPattern = passwordRegexPattern;
    }

    public void validateUser(UserDto userDto) {
        this.validatePassword(userDto.getPassword());
        this.validateIfEmailAlreadyExists(userDto.getEmail());
        this.validatePhones(userDto.getPhones());
    }

    private void validateIfEmailAlreadyExists(String email) {
        if (this.userRepository.existsByEmail(email)) {
            throw new BCIException("El correo ya registrado", HttpStatus.BAD_REQUEST);
        }
    }

    private void validatePassword(String password) {
        Matcher matcher = Pattern.compile(passwordRegexPattern).matcher(password);
        if (matcher.find()) {
            throw new BCIException("El formato del password es incorrecto", HttpStatus.BAD_REQUEST);
        }
    }

    private void validatePhones(List<PhoneDto> phones) throws BCIException {
        if (CollectionUtils.isEmpty(phones)) {
            return;
        }

        phones.forEach(this::validatePhone);
    }

    private void validatePhone(PhoneDto phoneDto) {
        Set<ConstraintViolation<PhoneDto>> phoneError = Validation.buildDefaultValidatorFactory()
                .getValidator()
                .validate(phoneDto);

        phoneError.stream()
                .map(ConstraintViolation::getMessage)
                .findFirst()
                .ifPresent(error -> {
                    throw new BCIException(error, HttpStatus.BAD_REQUEST);
                });
    }

}
