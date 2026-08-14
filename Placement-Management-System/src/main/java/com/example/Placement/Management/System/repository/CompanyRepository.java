package com.example.Placement.Management.System.repository;

import com.example.Placement.Management.System.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    // Find company by name
    Optional<Company> findByName(String name);

    // Check if a company exists by name
    boolean existsByName(String name);

    // Find companies by status (e.g., "Active", "Inactive")
    List<Company> findByStatus(String status);
}

