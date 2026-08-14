package com.example.Placement.Management.System.entity;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private Double eligibilityCgpa;

    @Column(nullable = false)
    private Double salaryPackage;

    @Column(nullable = false)
    private LocalDate deadline;

    @Column(nullable = false)
    private Boolean active = true;

    // Many jobs belong to one company
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    // One job can have many applications
    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Application> applications;

    // Constructors
    public Job() {}

    public Job(String title, String description, Double eligibilityCgpa,
               Double salaryPackage, LocalDate deadline, Boolean active, Company company) {
        this.title = title;
        this.description = description;
        this.eligibilityCgpa = eligibilityCgpa;
        this.salaryPackage = salaryPackage;
        this.deadline = deadline;
        this.active = active;
        this.company = company;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getEligibilityCgpa() { return eligibilityCgpa; }
    public void setEligibilityCgpa(Double eligibilityCgpa) { this.eligibilityCgpa = eligibilityCgpa; }

    public Double getSalaryPackage() { return salaryPackage; }
    public void setSalaryPackage(Double salaryPackage) { this.salaryPackage = salaryPackage; }

    public LocalDate getDeadline() { return deadline; }
    public void setDeadline(LocalDate deadline) { this.deadline = deadline; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public Company getCompany() { return company; }
    public void setCompany(Company company) { this.company = company; }

    public Set<Application> getApplications() { return applications; }
    public void setApplications(Set<Application> applications) { this.applications = applications; }
}

