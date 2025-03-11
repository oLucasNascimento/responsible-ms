package com.sportsfinance.responsible.api.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateResponsibleDTO {

    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String avatar;

}
