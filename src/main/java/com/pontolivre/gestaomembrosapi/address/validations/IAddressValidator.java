package com.pontolivre.gestaomembrosapi.address.validations;

import com.pontolivre.gestaomembrosapi.address.Address;

public interface IAddressValidator {
    void validateFields(Address address);
}
