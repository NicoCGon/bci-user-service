package com.bci.userservice.exception;

import com.bci.userservice.model.dto.ExceptionResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BCIException.class)
    protected ResponseEntity<Object> handleBCIException(BCIException ex, WebRequest request) {
        return handleExceptionInternal(ex, this.getObjectResponse(ex.getMessage()),
                new HttpHeaders(), ex.getHttpStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatusCode status, WebRequest request) {
        String message = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        return new ResponseEntity<>(this.getObjectResponse(message), HttpStatus.BAD_REQUEST);
    }

    private ExceptionResponseDto getObjectResponse(String message) {
        return ExceptionResponseDto.builder()
                .message(message)
                .build();
    }

}
