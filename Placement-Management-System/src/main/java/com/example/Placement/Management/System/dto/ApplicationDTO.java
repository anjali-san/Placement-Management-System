package com.example.Placement.Management.System.dto;

public class ApplicationDTO {
    private Long id;
    private Long studentId;
    private Long jobId;
    private String status;       // e.g., "Applied", "Shortlisted", "Rejected", "Selected"
    private String appliedDate;

    // Constructors
    public ApplicationDTO() {}

    public ApplicationDTO(Long id, Long studentId, Long jobId, String status, String appliedDate) {
        this.id = id;
        this.studentId = studentId;
        this.jobId = jobId;
        this.status = status;
        this.appliedDate = appliedDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }
}

