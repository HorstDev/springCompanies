package com.example.springCompanies.presentation.models.employee;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EmployeeViewModel {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
