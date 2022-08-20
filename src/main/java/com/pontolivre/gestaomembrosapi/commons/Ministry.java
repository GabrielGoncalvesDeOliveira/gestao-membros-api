package com.pontolivre.gestaomembrosapi.commons;

import lombok.Getter;

@Getter
public enum Ministry {
    PRESIDENCIA ("Presidência"),
    SUPERINTENDENCIA ("Superintendência"),
    PASTOREIO ("Pastoreio"),
    LIDERANCA ("Liderança"),
    DIACONATO ("Diaconato"),
    LOUVOR ("Louvor"),
    SECRETARIA ("Secretaria"),
    MIDIAS ("Mídias"),
    COREOGRAFIA ("Coreografia"),
    PROFESSOR ("Professor (a)"),
    CRIANCAS ("Crianças"),
    JOVENS ("Jovens"),
    HOMENS ("Homens"),
    MULHERES ("Mulheres"),
    EVANGELISMO ("Evangelismo"),
    SERVICOS_SOCIAIS ("Serviços Sociais");

    Ministry(String description) {
        this.description = description;
    }

    private final String description;
}
