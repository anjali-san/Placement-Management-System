package com.example.Placement.Management.System.service;

import com.example.Placement.Management.System.dto.CompanyDTO;
import com.example.Placement.Management.System.entity.Company;
import com.example.Placement.Management.System.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    // Constructor injection
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // Convert Entity -> DTO
    private CompanyDTO toDTO(Company company) {
        return new CompanyDTO(
                company.getId(),
                company.getName(),
                company.getStatus(),
                company.getDescription() // mapping description as "location" in DTO
        );
    }

    // Convert DTO -> Entity
    private Company toEntity(CompanyDTO dto) {
        Company company = new Company();
        company.setId(dto.getId());
        company.setName(dto.getName());
        company.setStatus(dto.getStatus());

        // Using DTO's "location" field to populate description
        company.setDescription(dto.getLocation());

        // Default placeholders for required fields
        company.setContactEmail("contact@example.com");
        company.setContactPhone("0000000000");

        return company;
    }

    // Get all companies
    public List<CompanyDTO> getAllCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Get company by ID
    public CompanyDTO getCompanyById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));
        return toDTO(company);
    }

    // Save or update company
    public CompanyDTO saveCompany(CompanyDTO companyDTO) {
        Company company = toEntity(companyDTO);
        Company saved = companyRepository.save(company);
        return toDTO(saved);
    }

    // Delete company by ID
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    // Find company by name
    public CompanyDTO getCompanyByName(String name) {
        Company company = companyRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Company not found with name: " + name));
        return toDTO(company);
    }

    // Check if company exists by name
    public boolean existsByName(String name) {
        return companyRepository.existsByName(name);
    }

    // Find companies by status
    public List<CompanyDTO> getCompaniesByStatus(String status) {
        return companyRepository.findByStatus(status)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
