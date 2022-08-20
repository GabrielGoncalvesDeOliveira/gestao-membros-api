package com.pontolivre.gestaomembrosapi.church.validations;

import com.pontolivre.gestaomembrosapi.church.domain.Church;
import com.pontolivre.gestaomembrosapi.exceptions.models.FieldsNotFilledException;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class ValidateChurch implements IChurchValidator{
    @Override
    public void validate(Church church) {
        if (isNull(church.getDenomination()) || church.getDenomination().isEmpty()
            || isNull(church.getCorporateName()) || church.getCorporateName().isEmpty()
            || isNull(church.getCnpj()) || church.getCnpj().isEmpty()
            || isNull(church.getPhone()) || church.getPhone().isEmpty()
            || isNull(church.getEmail()) || church.getEmail().isEmpty()
            || isNull(church.getAddress())) {

            throw new FieldsNotFilledException("All church fields must be filled");
        }
    }
}
