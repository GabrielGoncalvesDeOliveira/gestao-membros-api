package com.pontolivre.gestaomembrosapi.commons;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    private String street;
    private int number;
    private String complement;
    private String district;
    private String cep;
    private String city;
    private UF uf;
}
