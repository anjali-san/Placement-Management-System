package com.example.Placement.Management.System.dto;

public class JobDTO {
    private Long id;
    private String title;
    private Double salaryPackage;
    private Double eligibilityCgpa;
    private boolean active;
    private Long companyId;

    // Constructors
    public JobDTO() {}

    public JobDTO(Long id, String title, Double salaryPackage, Double eligibilityCgpa, boolean active, Long companyId) {
        this.id = id;
        this.title = title;
        this.salaryPackage = salaryPackage;
        this.eligibilityCgpa = eligibilityCgpa;
        this.active = active;
        this.companyId = companyId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getSalaryPackage() {
        return salaryPackage;
    }

    public void setSalaryPackage(Double salaryPackage) {
        this.salaryPackage = salaryPackage;
    }

    public Double getEligibilityCgpa() {
        return eligibilityCgpa;
    }

    public void setEligibilityCgpa(Double eligibilityCgpa) {
        this.eligibilityCgpa = eligibilityCgpa;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
