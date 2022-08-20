package com.pontolivre.gestaomembrosapi.address.service;

import com.pontolivre.gestaomembrosapi.address.Address;
import com.pontolivre.gestaomembrosapi.address.validations.IAddressValidator;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    private List<IAddressValidator> iAddressValidators;

    @Autowired
    public AddressService(ListableBeanFactory beanFactory) {
        this.iAddressValidators = new ArrayList<>(beanFactory.getBeansOfType(IAddressValidator.class).values());
    }

    public void validateFields(Address address) {
        iAddressValidators.forEach(validator -> validator.validateFields(address));
    }
}
