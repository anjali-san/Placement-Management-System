package com.example.Placement.Management.System.repository;

import com.example.Placement.Management.System.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    // Find skill by name
    Optional<Skill> findByName(String name);

    // Check if a skill already exists
    boolean existsByName(String name);
}

