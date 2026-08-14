package com.example.Placement.Management.System.service;

import com.example.Placement.Management.System.dto.SkillDTO;
import com.example.Placement.Management.System.entity.Skill;
import com.example.Placement.Management.System.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    // Constructor injection
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    // Convert Entity -> DTO
    private SkillDTO toDTO(Skill skill) {
        return new SkillDTO(skill.getId(), skill.getName(), skill.getLevel());
    }

    // Convert DTO -> Entity
    private Skill toEntity(SkillDTO dto) {
        Skill skill = new Skill();
        skill.setId(dto.getId());
        skill.setName(dto.getName());
        skill.setLevel(dto.getLevel());
        return skill;
    }

    // Get all skills
    public List<SkillDTO> getAllSkills() {
        return skillRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Get skill by ID
    public SkillDTO getSkillById(Long id) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found with id: " + id));
        return toDTO(skill);
    }

    // Save or update skill
    public SkillDTO saveSkill(SkillDTO skillDTO) {
        Skill skill = toEntity(skillDTO);
        Skill saved = skillRepository.save(skill);
        return toDTO(saved);
    }

    // Delete skill by ID
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

    // Find skill by name
    public Optional<SkillDTO> getSkillByName(String name) {
        return skillRepository.findByName(name).map(this::toDTO);
    }

    // Check if skill exists by name
    public boolean existsByName(String name) {
        return skillRepository.existsByName(name);
    }
}
