package com.example.springCompanies.core.application.common.mappers;

import com.example.springCompanies.core.domain.Employee;
import com.example.springCompanies.persistence.models.EmployeeEntity;
import com.example.springCompanies.presentation.models.employee.AddEmployeeViewModel;
import com.example.springCompanies.presentation.models.employee.EmployeeViewModel;

public interface EmployeeMapper {
    Employee mapToDomain(EmployeeEntity employeeEntity);
    EmployeeEntity mapToPersistence(Employee employee);
    EmployeeEntity mapToPersistence(AddEmployeeViewModel companyVm);
    EmployeeEntity mapToPersistence(EmployeeViewModel companyVm);
    EmployeeViewModel mapToViewModel(EmployeeEntity employeeEntity);
}
