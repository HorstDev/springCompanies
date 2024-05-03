package com.example.springCompanies.core.application.common.mappers;

import com.example.springCompanies.core.domain.Company;
import com.example.springCompanies.persistence.models.CompanyEntity;
import com.example.springCompanies.presentation.models.company.AddCompanyViewModel;
import com.example.springCompanies.presentation.models.company.CompanyViewModel;

public interface CompanyMapper {
    Company mapToDomain(CompanyEntity companyEntity);
    CompanyEntity mapToPersistence(Company company);
    CompanyEntity mapToPersistence(AddCompanyViewModel companyVm);
    CompanyEntity mapToPersistence(CompanyViewModel companyVm);
    CompanyViewModel mapToViewModel(CompanyEntity companyEntity);
}
