package com.example.Placement.Management.System.service;

import com.example.Placement.Management.System.dto.JobDTO;
import com.example.Placement.Management.System.entity.Company;
import com.example.Placement.Management.System.entity.Job;
import com.example.Placement.Management.System.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService {

    private final JobRepository jobRepository;

    // Constructor injection
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // Convert Entity -> DTO
    private JobDTO toDTO(Job job) {
        return new JobDTO(
                job.getId(),
                job.getTitle(),
                job.getSalaryPackage(),
                job.getEligibilityCgpa(),
                job.getActive(),
                job.getCompany() != null ? job.getCompany().getId() : null
        );
    }

    // Convert DTO -> Entity
    private Job toEntity(JobDTO dto) {
        Job job = new Job();
        job.setId(dto.getId());
        job.setTitle(dto.getTitle());
        job.setSalaryPackage(dto.getSalaryPackage());
        job.setEligibilityCgpa(dto.getEligibilityCgpa());
        job.setActive(dto.isActive());

        if (dto.getCompanyId() != null) {
            Company company = new Company();
            company.setId(dto.getCompanyId());
            job.setCompany(company);
        }
        return job;
    }

    // Get all jobs
    public List<JobDTO> getAllJobs() {
        return jobRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Get job by ID
    public JobDTO getJobById(Long id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));
        return toDTO(job);
    }

    // Save or update job
    public JobDTO saveJob(JobDTO jobDTO) {
        Job job = toEntity(jobDTO);
        Job saved = jobRepository.save(job);
        return toDTO(saved);
    }

    // Delete job by ID
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    // Get all active jobs
    public List<JobDTO> getActiveJobs() {
        return jobRepository.findByActiveTrue()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Get jobs by company ID
    public List<JobDTO> getJobsByCompanyId(Long companyId) {
        return jobRepository.findByCompanyId(companyId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Get jobs eligible for a given CGPA
    public List<JobDTO> getJobsByEligibilityCgpa(Double cgpa) {
        return jobRepository.findByEligibilityCgpaLessThanEqual(cgpa)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Get jobs with salary above a threshold
    public List<JobDTO> getJobsBySalary(Double salary) {
        return jobRepository.findBySalaryPackageGreaterThanEqual(salary)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
