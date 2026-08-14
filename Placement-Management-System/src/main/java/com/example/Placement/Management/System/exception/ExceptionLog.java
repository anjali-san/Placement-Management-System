package com.example.Placement.Management.System.exception;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exception_logs")
public class ExceptionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String exceptionType;
    private String message;
    private String stackTrace;
    private String status;       // e.g., "Resolved", "Pending"
    private Long userId;         // optional: who triggered the error
    private LocalDateTime timestamp;

    // Constructors
    public ExceptionLog() {}

    public ExceptionLog(String exceptionType, String message, String stackTrace,
                        String status, Long userId, LocalDateTime timestamp) {
        this.exceptionType = exceptionType;
        this.message = message;
        this.stackTrace = stackTrace;
        this.status = status;
        this.userId = userId;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getExceptionType() { return exceptionType; }
    public void setExceptionType(String exceptionType) { this.exceptionType = exceptionType; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getStackTrace() { return stackTrace; }
    public void setStackTrace(String stackTrace) { this.stackTrace = stackTrace; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}

