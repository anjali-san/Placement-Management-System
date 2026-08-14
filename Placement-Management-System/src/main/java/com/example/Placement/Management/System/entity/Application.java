package com.example.Placement.Management.System.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many applications belong to one student
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    // Many applications belong to one job
    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    private Job job;

    @Column(nullable = false)
    private LocalDate appliedDate;

    @Column(nullable = false)
    private String status; // e.g., "Submitted", "Shortlisted", "Rejected"

    // One application can have many interviews
    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Interview> interviews;

    // Constructors
    public Application() {}

    public Application(Student student, Job job, LocalDate appliedDate, String status) {
        this.student = student;
        this.job = job;
        this.appliedDate = appliedDate;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Job getJob() { return job; }
    public void setJob(Job job) { this.job = job; }

    public LocalDate getAppliedDate() { return appliedDate; }
    public void setAppliedDate(LocalDate appliedDate) { this.appliedDate = appliedDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Set<Interview> getInterviews() { return interviews; }
    public void setInterviews(Set<Interview> interviews) { this.interviews = interviews; }
}

