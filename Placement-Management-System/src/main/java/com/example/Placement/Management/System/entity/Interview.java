package com.example.Placement.Management.System.entity;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "interviews")
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many interviews belong to one application
    @ManyToOne
    @JoinColumn(name = "application_id", referencedColumnName = "id")
    private Application application;

    @Column(nullable = false)
    private Integer roundNumber;  // e.g., 1, 2, 3

    @Column(nullable = false)
    private LocalDate interviewDate;

    @Column(nullable = false)
    private String result; // e.g., "Selected", "Rejected", "Pending"

    @Column(length = 1000)
    private String feedback;

    // Constructors
    public Interview() {}

    public Interview(Application application, Integer roundNumber,
                     LocalDate interviewDate, String result, String feedback) {
        this.application = application;
        this.roundNumber = roundNumber;
        this.interviewDate = interviewDate;
        this.result = result;
        this.feedback = feedback;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Application getApplication() { return application; }
    public void setApplication(Application application) { this.application = application; }

    public Integer getRoundNumber() { return roundNumber; }
    public void setRoundNumber(Integer roundNumber) { this.roundNumber = roundNumber; }

    public LocalDate getInterviewDate() { return interviewDate; }
    public void setInterviewDate(LocalDate interviewDate) { this.interviewDate = interviewDate; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }
}
