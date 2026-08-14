package com.example.Placement.Management.System.controller;

import com.example.Placement.Management.System.dto.InterviewDTO;
import com.example.Placement.Management.System.service.InterviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {

    private final InterviewService interviewService;

    // Constructor injection
    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    // Get all interviews
    @GetMapping
    public List<InterviewDTO> getAllInterviews() {
        return interviewService.getAllInterviews();
    }

    // Get interview by ID
    @GetMapping("/{id}")
    public InterviewDTO getInterviewById(@PathVariable Long id) {
        return interviewService.getInterviewById(id);
    }

    // Create new interview
    @PostMapping
    public InterviewDTO createInterview(@RequestBody InterviewDTO interviewDTO) {
        return interviewService.saveInterview(interviewDTO);
    }

    // Update interview
    @PutMapping("/{id}")
    public InterviewDTO updateInterview(@PathVariable Long id, @RequestBody InterviewDTO interviewDTO) {
        interviewDTO.setId(id);
        return interviewService.saveInterview(interviewDTO);
    }

    // Delete interview
    @DeleteMapping("/{id}")
    public void deleteInterview(@PathVariable Long id) {
        interviewService.deleteInterview(id);
    }

    // Get interviews by application ID
    @GetMapping("/application/{applicationId}")
    public List<InterviewDTO> getInterviewsByApplicationId(@PathVariable Long applicationId) {
        return interviewService.getInterviewsByApplicationId(applicationId);
    }

    // Get interviews by round number
    @GetMapping("/round/{roundNumber}")
    public List<InterviewDTO> getInterviewsByRoundNumber(@PathVariable Integer roundNumber) {
        return interviewService.getInterviewsByRoundNumber(roundNumber);
    }

    // Get interviews by result
    @GetMapping("/result/{result}")
    public List<InterviewDTO> getInterviewsByResult(@PathVariable String result) {
        return interviewService.getInterviewsByResult(result);
    }
}

