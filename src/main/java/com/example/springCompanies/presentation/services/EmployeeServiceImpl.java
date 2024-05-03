package com.example.springCompanies.presentation.services;

import com.example.springCompanies.core.application.common.mappers.EmployeeMapper;
import com.example.springCompanies.core.application.common.services.EmployeeService;
import com.example.springCompanies.persistence.models.EmployeeEntity;
import com.example.springCompanies.persistence.repositories.CompanyRepository;
import com.example.springCompanies.persistence.repositories.EmployeeRepository;
import com.example.springCompanies.presentation.models.employee.AddEmployeeViewModel;
import com.example.springCompanies.presentation.models.employee.EmployeeViewModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, CompanyRepository companyRepository,
                               EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<EmployeeViewModel> getByCompanyId(Long companyId) {
        var result = new ArrayList<EmployeeViewModel>();
        var employeeEntities = employeeRepository.findAllByCompany_Id(companyId);

        for (var employeeEntity : employeeEntities) {
            result.add(employeeMapper.mapToViewModel(employeeEntity));
        }

        return result;
    }

    @Override
    public EmployeeViewModel getById(Long id) {
        EmployeeEntity employeeEntity =  employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Сотрудник с id " + id + " не найден!"));
        return employeeMapper.mapToViewModel(employeeEntity);
    }

    @Override
    public EmployeeViewModel create(Long companyId, AddEmployeeViewModel employeeVm) {
        var companyEntity = companyRepository.findById(companyId)
                .orElseThrow(() -> new NoSuchElementException("Компания не найдена!"));
        var employeeEntity = employeeMapper.mapToPersistence(employeeVm);
        employeeEntity.setCompany(companyEntity);
        employeeRepository.save(employeeEntity);

        return employeeMapper.mapToViewModel(employeeEntity);
    }

    @Override
    public EmployeeViewModel update(EmployeeViewModel employeeVm) {
        EmployeeEntity employeeEntity = employeeMapper.mapToPersistence(employeeVm);
        employeeRepository.save(employeeEntity);
        return employeeVm;
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
