package com.example.springCompanies.presentation.mappers;

import com.example.springCompanies.core.application.common.mappers.EmployeeMapper;
import com.example.springCompanies.core.domain.Employee;
import com.example.springCompanies.persistence.models.EmployeeEntity;
import com.example.springCompanies.presentation.models.employee.AddEmployeeViewModel;
import com.example.springCompanies.presentation.models.employee.EmployeeViewModel;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {
    @Override
    public Employee mapToDomain(EmployeeEntity employeeEntity) {
        return Employee.builder()
                .firstName(employeeEntity.getFirstName())
                .lastName(employeeEntity.getLastName())
                .birthDate(employeeEntity.getBirthDate())
                .build();
    }

    @Override
    public EmployeeEntity mapToPersistence(Employee employee) {
        return EmployeeEntity.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .birthDate(employee.getBirthDate())
                .build();
    }

    @Override
    public EmployeeEntity mapToPersistence(AddEmployeeViewModel employeeVm) {
        return EmployeeEntity.builder()
                .firstName(employeeVm.getFirstName())
                .lastName(employeeVm.getLastName())
                .birthDate(employeeVm.getBirthDate())
                .build();
    }

    @Override
    public EmployeeEntity mapToPersistence(EmployeeViewModel employeeVm) {
        return EmployeeEntity.builder()
                .id(employeeVm.getId())
                .firstName(employeeVm.getFirstName())
                .lastName(employeeVm.getLastName())
                .birthDate(employeeVm.getBirthDate())
                .build();
    }

    @Override
    public EmployeeViewModel mapToViewModel(EmployeeEntity employeeEntity) {
        return EmployeeViewModel.builder()
                .id(employeeEntity.getId())
                .firstName(employeeEntity.getFirstName())
                .lastName(employeeEntity.getLastName())
                .birthDate(employeeEntity.getBirthDate())
                .build();
    }
}
