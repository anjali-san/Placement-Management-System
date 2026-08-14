package com.example.Placement.Management.System.controller;


import com.example.Placement.Management.System.dto.JobDTO;
import com.example.Placement.Management.System.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    // Constructor injection
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // Get all jobs
    @GetMapping
    public List<JobDTO> getAllJobs() {
        return jobService.getAllJobs();
    }

    // Get job by ID
    @GetMapping("/{id}")
    public JobDTO getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    // Create new job
    @PostMapping
    public JobDTO createJob(@RequestBody JobDTO jobDTO) {
        return jobService.saveJob(jobDTO);
    }

    // Update job
    @PutMapping("/{id}")
    public JobDTO updateJob(@PathVariable Long id, @RequestBody JobDTO jobDTO) {
        jobDTO.setId(id);
        return jobService.saveJob(jobDTO);
    }

    // Delete job
    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
    }

    // Get active jobs
    @GetMapping("/active")
    public List<JobDTO> getActiveJobs() {
        return jobService.getActiveJobs();
    }

    // Get jobs by company ID
    @GetMapping("/company/{companyId}")
    public List<JobDTO> getJobsByCompanyId(@PathVariable Long companyId) {
        return jobService.getJobsByCompanyId(companyId);
    }

    // Get jobs eligible for a given CGPA
    @GetMapping("/eligible/{cgpa}")
    public List<JobDTO> getJobsByEligibilityCgpa(@PathVariable Double cgpa) {
        return jobService.getJobsByEligibilityCgpa(cgpa);
    }

    // Get jobs with salary above a threshold
    @GetMapping("/salary/{salary}")
    public List<JobDTO> getJobsBySalary(@PathVariable Double salary) {
        return jobService.getJobsBySalary(salary);
    }
}

