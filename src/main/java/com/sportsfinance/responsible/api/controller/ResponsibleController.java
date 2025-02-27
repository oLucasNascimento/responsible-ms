package com.sportsfinance.responsible.api.controller;

import com.sportsfinance.responsible.api.dto.ResponsibleDTO;
import com.sportsfinance.responsible.domain.service.ResponsibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/responsible")
public class ResponsibleController {

    @Autowired
    private ResponsibleService service;

    @PostMapping("/create")
    public ResponseEntity<ResponsibleDTO> createResponsible(@RequestBody ResponsibleDTO responsibleDTO) {
        ResponsibleDTO responsible = this.service.createResponsible(responsibleDTO);
        return ResponseEntity.ok(responsible);
    }

}
