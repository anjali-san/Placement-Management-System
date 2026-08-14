package com.example.Placement.Management.System.service;

import com.example.Placement.Management.System.dto.PlacementDTO;
import com.example.Placement.Management.System.entity.Company;
import com.example.Placement.Management.System.entity.Placement;
import com.example.Placement.Management.System.entity.Student;
import com.example.Placement.Management.System.repository.PlacementRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlacementService {

    private final PlacementRepository placementRepository;

    // Constructor injection
    public PlacementService(PlacementRepository placementRepository) {
        this.placementRepository = placementRepository;
    }

    // Convert Entity -> DTO
    private PlacementDTO toDTO(Placement placement) {
        return new PlacementDTO(
                placement.getId(),
                placement.getStudent().getId(),
                placement.getCompany().getId(),
                placement.getJobRole(),
                placement.getPackageOffered(),
                placement.getJoiningDate().toString(),
                placement.getStatus()
        );
    }

    // Convert DTO -> Entity
    private Placement toEntity(PlacementDTO dto) {
        Placement placement = new Placement();
        placement.setId(dto.getId());

        Student student = new Student();
        student.setId(dto.getStudentId());
        placement.setStudent(student);

        Company company = new Company();
        company.setId(dto.getCompanyId());
        placement.setCompany(company);

        placement.setJobRole(dto.getJobRole());
        placement.setPackageOffered(dto.getPackageOffered());

        if (dto.getJoiningDate() != null) {
            placement.setJoiningDate(LocalDate.parse(dto.getJoiningDate()));
        }

        placement.setStatus(dto.getStatus());
        return placement;
    }

    // Get all placements
    public List<PlacementDTO> getAllPlacements() {
        return placementRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Get placement by ID
    public PlacementDTO getPlacementById(Long id) {
        Placement placement = placementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Placement not found with id: " + id));
        return toDTO(placement);
    }

    // Save or update placement
    public PlacementDTO savePlacement(PlacementDTO placementDTO) {
        Placement placement = toEntity(placementDTO);
        Placement saved = placementRepository.save(placement);
        return toDTO(saved);
    }

    // Delete placement by ID
    public void deletePlacement(Long id) {
        placementRepository.deleteById(id);
    }

    // Find placement by student ID
    public PlacementDTO getPlacementByStudentId(Long studentId) {
        Placement placement = placementRepository.findByStudentId(studentId);
        if (placement == null) {
            throw new RuntimeException("Placement not found for studentId: " + studentId);
        }
        return toDTO(placement);
    }

    // Find placements by company ID
    public List<PlacementDTO> getPlacementsByCompanyId(Long companyId) {
        return placementRepository.findByCompanyId(companyId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Find placements by status
    public List<PlacementDTO> getPlacementsByStatus(String status) {
        return placementRepository.findByStatus(status)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
