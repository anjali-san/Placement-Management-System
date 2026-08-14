package com.example.Placement.Management.System.dto;


public class CompanyDTO {
    private Long id;
    private String name;
    private String status;   // e.g., "Active", "Inactive", "Blacklisted"
    private String location;

    // Constructors
    public CompanyDTO() {}

    public CompanyDTO(Long id, String name, String status, String location) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.location = location;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

