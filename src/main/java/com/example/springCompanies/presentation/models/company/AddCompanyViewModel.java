package com.example.springCompanies.presentation.models.company;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AddCompanyViewModel {
    private String name;
    private LocalDate dateOfFoundation;
}
