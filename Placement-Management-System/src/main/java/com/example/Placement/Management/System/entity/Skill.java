package com.example.Placement.Management.System.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    // New field: level (e.g., Beginner, Intermediate, Advanced)
    @Column(nullable = false)
    private String level;

    // Many skills can belong to many students
    @ManyToMany(mappedBy = "skills")
    private Set<Student> students;

    // Constructors
    public Skill() {}

    public Skill(String name, String level) {
        this.name = name;
        this.level = level;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public Set<Student> getStudents() { return students; }
    public void setStudents(Set<Student> students) { this.students = students; }
}
