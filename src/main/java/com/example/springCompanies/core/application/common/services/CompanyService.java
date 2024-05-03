package com.example.springCompanies.core.application.common.services;

import com.example.springCompanies.core.domain.Company;
import com.example.springCompanies.presentation.models.company.AddCompanyViewModel;
import com.example.springCompanies.presentation.models.company.CompanyViewModel;

import java.util.List;

public interface CompanyService {
    List<CompanyViewModel> getAll();
    CompanyViewModel getById(Long id);
    CompanyViewModel create(AddCompanyViewModel company);
    CompanyViewModel update(CompanyViewModel company);
    void delete(Long id);
}
