package com.example.Placement.Management.System.repository;

import com.example.Placement.Management.System.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Find student by email
    Optional<Student> findByEmail(String email);

    // Check if a student exists with a given email
    boolean existsByEmail(String email);

    // Find students by CGPA greater than or equal to a value
    java.util.List<Student> findByCgpaGreaterThanEqual(Double cgpa);
}

