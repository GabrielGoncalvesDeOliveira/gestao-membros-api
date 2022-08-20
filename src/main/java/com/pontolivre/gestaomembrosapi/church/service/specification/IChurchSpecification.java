package com.pontolivre.gestaomembrosapi.church.service.specification;

import com.pontolivre.gestaomembrosapi.church.domain.Church;
import com.pontolivre.gestaomembrosapi.church.domain.ChurchFilter;
import org.springframework.data.jpa.domain.Specification;

public interface IChurchSpecification {
    Specification<Church> specification(ChurchFilter churchFilter);
}
