package com.pontolivre.gestaomembrosapi.church.service;

import com.pontolivre.gestaomembrosapi.church.domain.Church;
import com.pontolivre.gestaomembrosapi.church.domain.ChurchFilter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IChurchService {
    Church create(Church church);

    boolean update(UUID churchId, Church church);

    boolean changeStatus(UUID churchId);

    Church getOne(UUID churchId);

    List<Church> getAll();

    List<Church> getByFilter(ChurchFilter filter);
}
