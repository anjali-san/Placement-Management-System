package com.example.Placement.Management.System.dto;

public class PlacementDTO {
    private Long id;
    private Long studentId;
    private Long companyId;
    private String jobRole;
    private Double packageOffered;
    private String joiningDate;
    private String status;   // e.g., "Placed", "Pending", "Rejected"

    // Constructors
    public PlacementDTO() {}

    public PlacementDTO(Long id, Long studentId, Long companyId,
                        String jobRole, Double packageOffered,
                        String joiningDate, String status) {
        this.id = id;
        this.studentId = studentId;
        this.companyId = companyId;
        this.jobRole = jobRole;
        this.packageOffered = packageOffered;
        this.joiningDate = joiningDate;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public Long getCompanyId() { return companyId; }
    public void setCompanyId(Long companyId) { this.companyId = companyId; }

    public String getJobRole() { return jobRole; }
    public void setJobRole(String jobRole) { this.jobRole = jobRole; }

    public Double getPackageOffered() { return packageOffered; }
    public void setPackageOffered(Double packageOffered) { this.packageOffered = packageOffered; }

    public String getJoiningDate() { return joiningDate; }
    public void setJoiningDate(String joiningDate) { this.joiningDate = joiningDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
