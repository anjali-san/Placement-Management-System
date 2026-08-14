package com.example.Placement.Management.System.controller;

import com.example.Placement.Management.System.dto.PlacementDTO;
import com.example.Placement.Management.System.service.PlacementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/placements")
public class PlacementController {

    private final PlacementService placementService;

    // Constructor injection
    public PlacementController(PlacementService placementService) {
        this.placementService = placementService;
    }

    // Get all placements
    @GetMapping
    public List<PlacementDTO> getAllPlacements() {
        return placementService.getAllPlacements();
    }

    // Get placement by ID
    @GetMapping("/{id}")
    public PlacementDTO getPlacementById(@PathVariable Long id) {
        return placementService.getPlacementById(id);
    }

    // Create new placement
    @PostMapping
    public PlacementDTO createPlacement(@RequestBody PlacementDTO placementDTO) {
        return placementService.savePlacement(placementDTO);
    }

    // Update placement
    @PutMapping("/{id}")
    public PlacementDTO updatePlacement(@PathVariable Long id, @RequestBody PlacementDTO placementDTO) {
        placementDTO.setId(id);
        return placementService.savePlacement(placementDTO);
    }

    // Delete placement
    @DeleteMapping("/{id}")
    public void deletePlacement(@PathVariable Long id) {
        placementService.deletePlacement(id);
    }

    // Get placements by student ID
    @GetMapping("/student/{studentId}")
    public PlacementDTO getPlacementByStudentId(@PathVariable Long studentId) {
        return placementService.getPlacementByStudentId(studentId);
    }

    // Get placements by company ID
    @GetMapping("/company/{companyId}")
    public List<PlacementDTO> getPlacementsByCompanyId(@PathVariable Long companyId) {
        return placementService.getPlacementsByCompanyId(companyId);
    }

    // Get placements by status
    @GetMapping("/status/{status}")
    public List<PlacementDTO> getPlacementsByStatus(@PathVariable String status) {
        return placementService.getPlacementsByStatus(status);
    }
}

