package com.example.Placement.Management.System.repository;


import com.example.Placement.Management.System.entity.Placement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlacementRepository extends JpaRepository<Placement, Long> {

    // Find placement record by student ID
    Placement findByStudentId(Long studentId);

    // Find all placements for a given company
    List<Placement> findByCompanyId(Long companyId);

    // Find placements by status (e.g., "Selected", "Joined", "Pending")
    List<Placement> findByStatus(String status);
}
