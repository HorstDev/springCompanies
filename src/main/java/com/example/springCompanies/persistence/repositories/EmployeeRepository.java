package com.example.springCompanies.persistence.repositories;

import com.example.springCompanies.persistence.models.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findAllByCompany_Id(Long companyId);
}
