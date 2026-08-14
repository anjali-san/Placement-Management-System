package com.example.Placement.Management.System.entity;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "placements")
public class Placement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // One student has one placement record
    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    // Many placements can belong to one company
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @Column(nullable = false)
    private String jobRole;

    @Column(nullable = false)
    private Double packageOffered;

    @Column(nullable = false)
    private LocalDate joiningDate;

    @Column(nullable = false)
    private String status; // e.g., "Selected", "Joined", "Pending"

    // Constructors
    public Placement() {}

    public Placement(Student student, Company company, String jobRole,
                     Double packageOffered, LocalDate joiningDate, String status) {
        this.student = student;
        this.company = company;
        this.jobRole = jobRole;
        this.packageOffered = packageOffered;
        this.joiningDate = joiningDate;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Company getCompany() { return company; }
    public void setCompany(Company company) { this.company = company; }

    public String getJobRole() { return jobRole; }
    public void setJobRole(String jobRole) { this.jobRole = jobRole; }

    public Double getPackageOffered() { return packageOffered; }
    public void setPackageOffered(Double packageOffered) { this.packageOffered = packageOffered; }

    public LocalDate getJoiningDate() { return joiningDate; }
    public void setJoiningDate(LocalDate joiningDate) { this.joiningDate = joiningDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

