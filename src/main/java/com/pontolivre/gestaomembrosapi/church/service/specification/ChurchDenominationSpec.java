package com.pontolivre.gestaomembrosapi.church.service.specification;

import com.pontolivre.gestaomembrosapi.church.domain.Church;
import com.pontolivre.gestaomembrosapi.church.domain.ChurchFilter;
import org.springframework.data.jpa.domain.Specification;

public class ChurchDenominationSpec implements IChurchSpecification {
    @Override
    public Specification<Church> specification(ChurchFilter churchFilter) {
        /*if (churchFilter.hasDenomination()) {
            return (root, query, cb) -> cb.like(root.get(Church_.denomination));
        }*/
        return null;
    }
}