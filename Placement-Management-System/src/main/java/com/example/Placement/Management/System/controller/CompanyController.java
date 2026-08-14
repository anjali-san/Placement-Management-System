package com.example.Placement.Management.System.controller;

import com.example.Placement.Management.System.dto.CompanyDTO;
import com.example.Placement.Management.System.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    // Constructor injection
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    // Get all companies
    @GetMapping
    public List<CompanyDTO> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    // Get company by ID
    @GetMapping("/{id}")
    public CompanyDTO getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    // Create new company
    @PostMapping
    public CompanyDTO createCompany(@RequestBody CompanyDTO companyDTO) {
        return companyService.saveCompany(companyDTO);
    }

    // Update company
    @PutMapping("/{id}")
    public CompanyDTO updateCompany(@PathVariable Long id, @RequestBody CompanyDTO companyDTO) {
        companyDTO.setId(id);
        return companyService.saveCompany(companyDTO);
    }

    // Delete company
    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
    }

    // Get company by name
    @GetMapping("/name/{name}")
    public CompanyDTO getCompanyByName(@PathVariable String name) {
        return companyService.getCompanyByName(name);
    }

    // Check if company exists by name
    @GetMapping("/exists/{name}")
    public boolean existsByName(@PathVariable String name) {
        return companyService.existsByName(name);
    }

    // Get companies by status
    @GetMapping("/status/{status}")
    public List<CompanyDTO> getCompaniesByStatus(@PathVariable String status) {
        return companyService.getCompaniesByStatus(status);
    }
}

