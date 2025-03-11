package com.sportsfinance.responsible.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateResponsibleDTO {

    @NotBlank(message = "{name.not.blank}")
    private String name;

    @Email(message = "{email.valid.message}")
    private String email;

    @NotBlank(message = "{password.not.blank}")
    private String password;


    private String phoneNumber;
    private String avatar;

}
