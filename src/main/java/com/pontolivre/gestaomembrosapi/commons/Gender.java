package com.pontolivre.gestaomembrosapi.commons;

import lombok.Getter;

@Getter
public enum Gender {

    MASCULINO("Masculino"),
    FEMININO("Feminino");

    Gender(String gender) {
        this.gender = gender;
    }

    private final String gender;
}
