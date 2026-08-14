package com.example.Placement.Management.System.repository;

import com.example.Placement.Management.System.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    // Find all applications for a given student
    List<Application> findByStudentId(Long studentId);

    // Find all applications for a given job
    List<Application> findByJobId(Long jobId);

    // Find applications by status (e.g., "Submitted", "Shortlisted", "Rejected")
    List<Application> findByStatus(String status);
}

