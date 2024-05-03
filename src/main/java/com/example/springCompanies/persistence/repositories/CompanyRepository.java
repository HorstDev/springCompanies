package com.example.springCompanies.persistence.repositories;

import com.example.springCompanies.persistence.models.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
}
