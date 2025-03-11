package com.sportsfinance.responsible.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticateResponsibleDTO {

    private String email;
    private String password;

}
