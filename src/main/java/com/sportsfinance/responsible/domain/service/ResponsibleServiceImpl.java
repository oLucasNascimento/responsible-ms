package com.sportsfinance.responsible.domain.service;

import com.sportsfinance.responsible.api.dto.ResponsibleDTO;
import com.sportsfinance.responsible.api.mapper.ResponsibleMapper;
import com.sportsfinance.responsible.domain.repository.ResponsibleRepository;
import com.sportsfinance.responsible.exception.AlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponsibleServiceImpl implements ResponsibleService {

    @Autowired
    private ResponsibleRepository repository;

    @Autowired
    private ResponsibleMapper mapper;

    @Override
    public ResponsibleDTO createResponsible(ResponsibleDTO responsibleDTO) {
        if (this.repository.findByEmail(responsibleDTO.getEmail()) != null) throw new AlreadyExistsException("Responsible already exists");
        return this.mapper.toResponsibleDTO(this.repository.save(this.mapper.toResponsible(responsibleDTO)));
    }
}
