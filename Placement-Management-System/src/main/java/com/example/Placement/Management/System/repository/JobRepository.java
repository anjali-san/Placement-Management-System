package com.example.Placement.Management.System.repository;


import com.example.Placement.Management.System.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    // Find all active jobs
    List<Job> findByActiveTrue();

    // Find jobs by company ID
    List<Job> findByCompanyId(Long companyId);

    // Find jobs with eligibility CGPA less than or equal to a value
    List<Job> findByEligibilityCgpaLessThanEqual(Double cgpa);

    // Find jobs with salary package greater than or equal to a value
    List<Job> findBySalaryPackageGreaterThanEqual(Double salary);
}

