package com.example.Placement.Management.System.service;

import com.example.Placement.Management.System.dto.ApplicationDTO;
import com.example.Placement.Management.System.entity.Application;
import com.example.Placement.Management.System.entity.Job;
import com.example.Placement.Management.System.entity.Student;
import com.example.Placement.Management.System.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    // Constructor injection
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    // Convert Entity -> DTO
    private ApplicationDTO toDTO(Application application) {
        return new ApplicationDTO(
                application.getId(),
                application.getStudent().getId(),
                application.getJob().getId(),
                application.getStatus(),
                application.getAppliedDate().toString()
        );
    }

    // Convert DTO -> Entity
    private Application toEntity(ApplicationDTO dto) {
        Application application = new Application();
        application.setId(dto.getId());

        Student student = new Student();
        student.setId(dto.getStudentId());
        application.setStudent(student);

        Job job = new Job();
        job.setId(dto.getJobId());
        application.setJob(job);

        if (dto.getAppliedDate() != null) {
            application.setAppliedDate(LocalDate.parse(dto.getAppliedDate()));
        }

        application.setStatus(dto.getStatus());
        return application;
    }

    // Get all applications
    public List<ApplicationDTO> getAllApplications() {
        return applicationRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Get application by ID
    public ApplicationDTO getApplicationById(Long id) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found with id: " + id));
        return toDTO(application);
    }

    // Save or update application
    public ApplicationDTO saveApplication(ApplicationDTO applicationDTO) {
        Application application = toEntity(applicationDTO);
        Application saved = applicationRepository.save(application);
        return toDTO(saved);
    }

    // Delete application by ID
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }

    // Get applications by student ID
    public List<ApplicationDTO> getApplicationsByStudentId(Long studentId) {
        return applicationRepository.findByStudentId(studentId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Get applications by job ID
    public List<ApplicationDTO> getApplicationsByJobId(Long jobId) {
        return applicationRepository.findByJobId(jobId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Get applications by status
    public List<ApplicationDTO> getApplicationsByStatus(String status) {
        return applicationRepository.findByStatus(status)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
