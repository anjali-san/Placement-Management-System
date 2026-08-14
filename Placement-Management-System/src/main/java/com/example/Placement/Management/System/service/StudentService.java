package com.example.Placement.Management.System.service;

import com.example.Placement.Management.System.dto.StudentDTO;
import com.example.Placement.Management.System.entity.Student;
import com.example.Placement.Management.System.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // Constructor injection
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Convert Entity -> DTO
    private StudentDTO toDTO(Student student) {
        return new StudentDTO(student.getId(), student.getName(), student.getEmail(), student.getCgpa());
    }

    // Convert DTO -> Entity
    private Student toEntity(StudentDTO dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCgpa(dto.getCgpa());
        return student;
    }

    // Get all students
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Get student by ID
    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return toDTO(student);
    }

    // Save or update student
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = toEntity(studentDTO);
        Student saved = studentRepository.save(student);
        return toDTO(saved);
    }

    // Delete student by ID
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // Find student by email
    public Optional<StudentDTO> getStudentByEmail(String email) {
        return studentRepository.findByEmail(email).map(this::toDTO);
    }

    // Check if student exists by email
    public boolean existsByEmail(String email) {
        return studentRepository.existsByEmail(email);
    }

    // Find students eligible by CGPA
    public List<StudentDTO> getEligibleStudents(Double cgpa) {
        return studentRepository.findByCgpaGreaterThanEqual(cgpa)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
