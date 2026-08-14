package com.example.Placement.Management.System.dto;

public class SkillDTO {
    private Long id;
    private String name;
    private String level; // e.g., Beginner, Intermediate, Advanced

    // Constructors
    public SkillDTO() {}

    public SkillDTO(Long id, String name, String level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
