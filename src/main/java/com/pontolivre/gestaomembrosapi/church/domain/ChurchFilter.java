package com.pontolivre.gestaomembrosapi.church.domain;

import lombok.*;
import org.springframework.data.jpa.domain.Specification;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChurchFilter {
    private String denomination;
    private String corporateName;
    private String cnpj;
    private String phone;
    private String email;

    public boolean hasDenomination() {
        return !denomination.trim().isEmpty();
    }

    public boolean hasCorporateName() {
        return !corporateName.trim().isEmpty();
    }

    public boolean hasCnpj() {
        return !cnpj.trim().isEmpty();
    }

    public boolean hasPhone() {
        return !phone.trim().isEmpty();
    }

    public boolean hasEmail() {
        return !email.trim().isEmpty();
    }
}