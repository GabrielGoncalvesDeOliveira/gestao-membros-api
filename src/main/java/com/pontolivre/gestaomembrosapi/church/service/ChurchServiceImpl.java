package com.pontolivre.gestaomembrosapi.church.service;

import com.pontolivre.gestaomembrosapi.address.service.AddressService;
import com.pontolivre.gestaomembrosapi.church.domain.Church;
import com.pontolivre.gestaomembrosapi.church.domain.ChurchFilter;
import com.pontolivre.gestaomembrosapi.church.infrastructure.IChurchJpaRepository;
import com.pontolivre.gestaomembrosapi.church.validations.IChurchValidator;
import com.pontolivre.gestaomembrosapi.commons.utils.UtilService;
import com.pontolivre.gestaomembrosapi.exceptions.models.ResourceNotFoundException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ChurchServiceImpl implements IChurchService {

    @Autowired
    private IChurchJpaRepository iChurchJpaRepository;
    @Autowired
    private AddressService addressService;

    private List<IChurchValidator> validators;

    @Autowired
    public ChurchServiceImpl(ListableBeanFactory beanFactory) {
        this.validators = new ArrayList<>(beanFactory.getBeansOfType(IChurchValidator.class).values());
    }

    @Override
    public Church create(Church church) {
        validateFields(church);
        church.setCreatedAt(UtilService.dateTimeNow());

        return iChurchJpaRepository.save(church);
    }

    @Override
    public boolean update(UUID churchId, Church church) {
        Optional<Church> churchOptional = iChurchJpaRepository.findById(churchId);
        if (churchOptional.isPresent()) {
            validateFields(church);
            Church churchInBase = churchOptional.get();

            churchInBase.setDenomination(church.getDenomination());
            churchInBase.setCnpj(church.getCnpj());
            churchInBase.setEmail(church.getEmail());
            churchInBase.setAddress(church.getAddress());
            churchInBase.setPhone(church.getPhone());
            churchInBase.setCorporateName(church.getCorporateName());
            church.setChangedAt(UtilService.dateTimeNow());

            iChurchJpaRepository.save(churchInBase);

            return true;
        }
        else throw new ResourceNotFoundException("Church not founded");
    }

    @Override
    public boolean changeStatus(UUID churchId) {
        Optional<Church> churchOptional = iChurchJpaRepository.findById(churchId);
        if (churchOptional.isPresent()) {
            Church church = churchOptional.get();

            church.setActive(!church.isActive());
            church.setChangedAt(UtilService.dateTimeNow());

            iChurchJpaRepository.save(church);

            return true;
        }
        else throw new ResourceNotFoundException("Church not founded");
    }

    @Override
    public Church getOne(UUID churchId) {
        Optional<Church> churchOptional = iChurchJpaRepository.findById(churchId);
        if (churchOptional.isPresent()) {
            return churchOptional.get();
        }
        else throw new ResourceNotFoundException("Church not founded");
    }

    @Override
    public List<Church> getAll() {
        return iChurchJpaRepository.findAll().stream()
                .sorted(Comparator.comparing(Church::getDenomination))
                .collect(Collectors.toList());
    }

    @Override
    public List<Church> getByFilter(ChurchFilter filter) {
        return null;
    }

    private void validateFields(Church church) {
        validators.forEach(validator -> validator.validate(church));

        addressService.validateFields(church.getAddress());
    }
}
