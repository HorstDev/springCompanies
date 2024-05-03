package com.example.springCompanies.presentation.services;

import com.example.springCompanies.core.application.common.mappers.CompanyMapper;
import com.example.springCompanies.persistence.models.CompanyEntity;
import com.example.springCompanies.persistence.repositories.CompanyRepository;
import com.example.springCompanies.core.application.common.services.CompanyService;
import com.example.springCompanies.presentation.models.company.AddCompanyViewModel;
import com.example.springCompanies.presentation.models.company.CompanyViewModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public List<CompanyViewModel> getAll() {
        List<CompanyViewModel> result = new ArrayList<>();
        List<CompanyEntity> companyEntities = companyRepository.findAll();

        for (CompanyEntity companyEntity : companyEntities) {
            result.add(companyMapper.mapToViewModel(companyEntity));
        }

        return result;
    }

    @Override
    public CompanyViewModel getById(Long id) throws NoSuchElementException {
        CompanyEntity companyEntity = companyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Компания не найдена!"));
        return companyMapper.mapToViewModel(companyEntity);
    }

    @Override
    public CompanyViewModel create(AddCompanyViewModel companyVm) {
        CompanyEntity companyEntity = companyMapper.mapToPersistence(companyVm);
        companyRepository.save(companyEntity);
        return companyMapper.mapToViewModel(companyEntity);
    }

    @Override
    public CompanyViewModel update(CompanyViewModel companyVm) {
        CompanyEntity companyEntity = companyMapper.mapToPersistence(companyVm);
        companyRepository.save(companyEntity);
        return companyVm;
    }

    @Override
    public void delete(Long id) {
        companyRepository.deleteById(id);
    }
}
