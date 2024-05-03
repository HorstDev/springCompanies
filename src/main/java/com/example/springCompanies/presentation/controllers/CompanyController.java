package com.example.springCompanies.presentation.controllers;

import com.example.springCompanies.core.application.common.services.CompanyService;
import com.example.springCompanies.presentation.models.company.AddCompanyViewModel;
import com.example.springCompanies.presentation.models.company.CompanyViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping()
    public List<CompanyViewModel> getAllCompanies() {
        return companyService.getAll();
    }

    @GetMapping("{id}")
    public CompanyViewModel findCompanyById(@PathVariable Long id) {
        return companyService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyViewModel addCompany(@RequestBody AddCompanyViewModel addCompanyVm) {
        return companyService.create(addCompanyVm);
    }

    @PutMapping()
    public CompanyViewModel updateCompany(@RequestBody CompanyViewModel addCompanyVm) {
        return companyService.update(addCompanyVm);
    }

    @DeleteMapping("{id}")
    public void deleteCompanyById(@PathVariable Long id) {
        companyService.delete(id);
    }
}
