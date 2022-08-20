package com.pontolivre.gestaomembrosapi.church.infrastructure;

import com.pontolivre.gestaomembrosapi.church.domain.Church;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IChurchJpaRepository extends JpaRepository<Church, UUID> {

    List<Church> findAll(Specification<Church> specification);
}
