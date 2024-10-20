package com.pruebatecnicainditex.priceservice.aplication.exceptions;

import com.pruebatecnicainditex.priceservice.infrastructure.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDto> runtimeExpectionHandler(RuntimeException ex) {
        ErrorDto error = ErrorDto.builder().message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
