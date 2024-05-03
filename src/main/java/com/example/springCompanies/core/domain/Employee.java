package com.example.springCompanies.core.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Employee {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
