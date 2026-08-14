package com.example.Placement.Management.System.service;

import com.example.Placement.Management.System.dto.InterviewDTO;
import com.example.Placement.Management.System.entity.Application;
import com.example.Placement.Management.System.entity.Interview;
import com.example.Placement.Management.System.repository.InterviewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterviewService {

    private final InterviewRepository interviewRepository;

    // Constructor injection
    public InterviewService(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    // Convert Entity -> DTO
    private InterviewDTO toDTO(Interview interview) {
        return new InterviewDTO(
                interview.getId(),
                interview.getApplication().getId(),
                interview.getRoundNumber(),
                interview.getResult(),
                interview.getInterviewDate().toString()
        );
    }

    // Convert DTO -> Entity
    private Interview toEntity(InterviewDTO dto) {
        Interview interview = new Interview();
        interview.setId(dto.getId());

        Application application = new Application();
        application.setId(dto.getApplicationId());
        interview.setApplication(application);

        interview.setRoundNumber(dto.getRoundNumber());
        interview.setResult(dto.getResult());

        if (dto.getScheduledDate() != null) {
            interview.setInterviewDate(LocalDate.parse(dto.getScheduledDate()));
        }

        return interview;
    }

    // Get all interviews
    public List<InterviewDTO> getAllInterviews() {
        return interviewRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Get interview by ID
    public InterviewDTO getInterviewById(Long id) {
        Interview interview = interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found with id: " + id));
        return toDTO(interview);
    }

    // Save or update interview
    public InterviewDTO saveInterview(InterviewDTO interviewDTO) {
        Interview interview = toEntity(interviewDTO);
        Interview saved = interviewRepository.save(interview);
        return toDTO(saved);
    }

    // Delete interview by ID
    public void deleteInterview(Long id) {
        interviewRepository.deleteById(id);
    }

    // Get interviews by application ID
    public List<InterviewDTO> getInterviewsByApplicationId(Long applicationId) {
        return interviewRepository.findByApplicationId(applicationId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Get interviews by round number
    public List<InterviewDTO> getInterviewsByRoundNumber(Integer roundNumber) {
        return interviewRepository.findByRoundNumber(roundNumber)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Get interviews by result
    public List<InterviewDTO> getInterviewsByResult(String result) {
        return interviewRepository.findByResult(result)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
