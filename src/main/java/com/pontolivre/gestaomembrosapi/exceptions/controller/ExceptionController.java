package com.pontolivre.gestaomembrosapi.exceptions.controller;

import com.pontolivre.gestaomembrosapi.exceptions.models.FieldsNotFilledException;
import com.pontolivre.gestaomembrosapi.exceptions.dto.DefaultErrorDTO;
import com.pontolivre.gestaomembrosapi.exceptions.models.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(FieldsNotFilledException.class)
    public ResponseEntity<DefaultErrorDTO> allFieldsMustBeFilled(FieldsNotFilledException exception) {
        DefaultErrorDTO defaultErrorDTO = new DefaultErrorDTO(exception.getLocalizedMessage());
        return new ResponseEntity<>(defaultErrorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<DefaultErrorDTO> resourceNotFound(ResourceNotFoundException exception) {
        DefaultErrorDTO defaultErrorDTO = new DefaultErrorDTO(exception.getLocalizedMessage());
        return new ResponseEntity<>(defaultErrorDTO, HttpStatus.NOT_FOUND);
    }
}
