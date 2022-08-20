package com.pontolivre.gestaomembrosapi.address.validations;

import com.pontolivre.gestaomembrosapi.address.Address;
import com.pontolivre.gestaomembrosapi.exceptions.models.FieldsNotFilledException;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class ValidateAddress implements IAddressValidator {
    @Override
    public void validateFields(Address address) {
        if (isNull(address.getStreet()) || address.getStreet().isEmpty()
            || address.getNumber() == 0
            || isNull(address.getCity()) || address.getCity().isEmpty()
            || isNull(address.getUf())) {

            throw new FieldsNotFilledException("All address fields must be filled");
        }
    }
}
