package com.example.Placement.Management.System.controller;

import com.example.Placement.Management.System.dto.ApplicationDTO;
import com.example.Placement.Management.System.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    // Constructor injection
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    // Get all applications
    @GetMapping
    public List<ApplicationDTO> getAllApplications() {
        return applicationService.getAllApplications();
    }

    // Get application by ID
    @GetMapping("/{id}")
    public ApplicationDTO getApplicationById(@PathVariable Long id) {
        return applicationService.getApplicationById(id);
    }

    // Create new application
    @PostMapping
    public ApplicationDTO createApplication(@RequestBody ApplicationDTO applicationDTO) {
        return applicationService.saveApplication(applicationDTO);
    }

    // Update application
    @PutMapping("/{id}")
    public ApplicationDTO updateApplication(@PathVariable Long id, @RequestBody ApplicationDTO applicationDTO) {
        applicationDTO.setId(id);
        return applicationService.saveApplication(applicationDTO);
    }

    // Delete application
    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
    }

    // Get applications by student ID
    @GetMapping("/student/{studentId}")
    public List<ApplicationDTO> getApplicationsByStudentId(@PathVariable Long studentId) {
        return applicationService.getApplicationsByStudentId(studentId);
    }

    // Get applications by job ID
    @GetMapping("/job/{jobId}")
    public List<ApplicationDTO> getApplicationsByJobId(@PathVariable Long jobId) {
        return applicationService.getApplicationsByJobId(jobId);
    }

    // Get applications by status
    @GetMapping("/status/{status}")
    public List<ApplicationDTO> getApplicationsByStatus(@PathVariable String status) {
        return applicationService.getApplicationsByStatus(status);
    }
}

