package com.example.Placement.Management.System.repository;

import com.example.Placement.Management.System.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InterviewRepository extends JpaRepository<Interview, Long> {

    // Find all interviews for a given application
    List<Interview> findByApplicationId(Long applicationId);

    // Find interviews by round number
    List<Interview> findByRoundNumber(Integer roundNumber);

    // Find interviews by result (e.g., "Selected", "Rejected", "Pending")
    List<Interview> findByResult(String result);
}

