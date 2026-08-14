package com.example.Placement.Management.System.dto;


public class InterviewDTO {
    private Long id;
    private Long applicationId;
    private Integer roundNumber;
    private String result;       // e.g., "Selected", "Rejected", "Pending"
    private String scheduledDate;

    // Constructors
    public InterviewDTO() {}

    public InterviewDTO(Long id, Long applicationId, Integer roundNumber, String result, String scheduledDate) {
        this.id = id;
        this.applicationId = applicationId;
        this.roundNumber = roundNumber;
        this.result = result;
        this.scheduledDate = scheduledDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(Integer roundNumber) {
        this.roundNumber = roundNumber;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate;
    }
}

