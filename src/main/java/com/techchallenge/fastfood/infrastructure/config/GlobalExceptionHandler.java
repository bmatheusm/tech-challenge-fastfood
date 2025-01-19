package com.techchallenge.fastfood.infrastructure.config;

import com.techchallenge.fastfood.domain.exception.PagamentoPendenteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PagamentoPendenteException.class)
    public ResponseEntity<String> handlePagamentoPendenteException(PagamentoPendenteException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}