package com.example.springCompanies.presentation.mappers;

import com.example.springCompanies.core.domain.Company;
import com.example.springCompanies.core.application.common.mappers.CompanyMapper;
import com.example.springCompanies.persistence.models.CompanyEntity;
import com.example.springCompanies.presentation.models.company.AddCompanyViewModel;
import com.example.springCompanies.presentation.models.company.CompanyViewModel;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapperImpl implements CompanyMapper {
    @Override
    public Company mapToDomain(CompanyEntity companyEntity) {
        return Company.builder()
                .name(companyEntity.getName())
                .dateOfFoundation(companyEntity.getDateOfFoundation())
                .build();
    }

    @Override
    public CompanyEntity mapToPersistence(Company company) {
        return CompanyEntity.builder()
                .name(company.getName())
                .dateOfFoundation(company.getDateOfFoundation())
                .build();
    }

    @Override
    public CompanyEntity mapToPersistence(AddCompanyViewModel addCompanyVm) {
        return CompanyEntity.builder()
                .name(addCompanyVm.getName())
                .dateOfFoundation(addCompanyVm.getDateOfFoundation())
                .build();
    }

    @Override
    public CompanyEntity mapToPersistence(CompanyViewModel companyVm) {
        return CompanyEntity.builder()
                .id(companyVm.getId())
                .name(companyVm.getName())
                .dateOfFoundation(companyVm.getDateOfFoundation())
                .build();
    }

    @Override
    public CompanyViewModel mapToViewModel(CompanyEntity companyEntity) {
        return CompanyViewModel.builder()
                .id(companyEntity.getId())
                .name(companyEntity.getName())
                .dateOfFoundation(companyEntity.getDateOfFoundation())
                .build();
    }
}
