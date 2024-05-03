package com.example.springCompanies.presentation.controllers;

import com.example.springCompanies.core.application.common.services.EmployeeService;
import com.example.springCompanies.presentation.models.employee.AddEmployeeViewModel;
import com.example.springCompanies.presentation.models.employee.EmployeeViewModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employees-in-company/{companyId}")
    public List<EmployeeViewModel> getByCompanyId(@PathVariable Long companyId) {
        return employeeService.getByCompanyId(companyId);
    }

    @GetMapping("{id}")
    public EmployeeViewModel getById(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @PostMapping("add-employee-to-company/{companyId}")
    public EmployeeViewModel create(@PathVariable Long companyId, @RequestBody AddEmployeeViewModel employeeVm) {
        return employeeService.create(companyId, employeeVm);
    }

    @PutMapping()
    public EmployeeViewModel update(EmployeeViewModel employeeVm) {
        return employeeService.update(employeeVm);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }
}
