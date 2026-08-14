package com.example.Placement.Management.System.controller;


import com.example.Placement.Management.System.dto.SkillDTO;
import com.example.Placement.Management.System.service.SkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService skillService;

    // Constructor injection
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    // Get all skills
    @GetMapping
    public List<SkillDTO> getAllSkills() {
        return skillService.getAllSkills();
    }

    // Get skill by ID
    @GetMapping("/{id}")
    public SkillDTO getSkillById(@PathVariable Long id) {
        return skillService.getSkillById(id);
    }

    // Create new skill
    @PostMapping
    public SkillDTO createSkill(@RequestBody SkillDTO skillDTO) {
        return skillService.saveSkill(skillDTO);
    }

    // Update skill
    @PutMapping("/{id}")
    public SkillDTO updateSkill(@PathVariable Long id, @RequestBody SkillDTO skillDTO) {
        skillDTO.setId(id);
        return skillService.saveSkill(skillDTO);
    }

    // Delete skill
    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
    }
}

