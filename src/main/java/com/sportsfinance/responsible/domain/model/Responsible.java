package com.sportsfinance.responsible.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Responsible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String responsibleId;

    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String avatar;
    private LocalDateTime createDate = LocalDateTime.now();
    private LocalDateTime updateDate = LocalDateTime.now();
}
