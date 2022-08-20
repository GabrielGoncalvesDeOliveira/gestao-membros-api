package com.pontolivre.gestaomembrosapi.commons;

import lombok.Getter;

@Getter
public enum MaritalStatus {

    SOLTEIRO("Solteiro (a)"),
    CASADO("Casado (a)"),
    DIVORCIADO("Divorciado (a)"),
    VIUVO("Viúvo (a)"),
    UNIAO_ESTAVEL("União Estável");

    MaritalStatus(String status) {
        this.status = status;
    }

    private final String status;
}
