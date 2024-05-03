package com.example.springCompanies.core.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Company {
    private String name;
    private LocalDate dateOfFoundation;
}
