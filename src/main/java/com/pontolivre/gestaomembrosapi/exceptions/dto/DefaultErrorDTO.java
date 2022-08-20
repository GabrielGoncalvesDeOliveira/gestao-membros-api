package com.pontolivre.gestaomembrosapi.exceptions.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class DefaultErrorDTO implements Serializable {

    private final String message;

    public DefaultErrorDTO(String message) {
        this.message = message;
    }
}
