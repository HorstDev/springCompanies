package com.example.springCompanies.core.application.common.services;

import com.example.springCompanies.presentation.models.employee.AddEmployeeViewModel;
import com.example.springCompanies.presentation.models.employee.EmployeeViewModel;

import java.util.List;
import java.util.NoSuchElementException;

public interface EmployeeService {
    List<EmployeeViewModel> getByCompanyId(Long companyId);
    EmployeeViewModel getById(Long id) throws NoSuchElementException;
    EmployeeViewModel create(Long companyId, AddEmployeeViewModel employee);
    EmployeeViewModel update(EmployeeViewModel employee);
    void delete(Long id);
}
