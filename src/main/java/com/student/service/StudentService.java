package com.student.service;

import com.student.dto.StudentPage;
import com.student.dto.StudentResponse;
import com.student.entity.Student;
import com.student.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentPage getStudents(int page, int size, String nameFilter) {
        Page<Student> p;
        if (nameFilter == null || nameFilter.isBlank()) {
            p = studentRepository.findAll(PageRequest.of(page, size));
        } else {
            p = studentRepository.findByNameContainingIgnoreCase(nameFilter, PageRequest.of(page, size));
        }
        List<Student> students = p.getContent();
        return StudentPage.builder()
                .students(students)
                .totalCount((int)p.getTotalElements())
                .build();
    }

    public StudentResponse addStudent(Student student) {
        if (student.getName() == null || student.getName().isBlank()) {
            return StudentResponse.builder().status("Failure").message("Name is required").build();
        }
        Student savedStudent = studentRepository.save(student);
        return StudentResponse.builder().status("Success").studentId(savedStudent.getId()).message("Created").build();
    }

    public StudentResponse updateStudent(Long id, Student student) {
        Optional<Student> existing = studentRepository.findById(id);
        if (existing.isEmpty()) {
            return StudentResponse.builder().status("Failure").message("Student not found").build();
        }
        Student s = existing.get();
        if (student.getName() != null && !student.getName().isBlank()) s.setName(student.getName());
        if (student.getContact() != null) s.setContact(student.getContact());
        Student saved = studentRepository.save(s);
        return StudentResponse.builder().status("Success").studentId(saved.getId()).message("Updated").build();
    }

    public StudentResponse deleteStudent(Long id) {
        Optional<Student> existing = studentRepository.findById(id);
        if (existing.isEmpty()) {
            return StudentResponse.builder().status("Failure").message("Student not found").build();
        }
        studentRepository.deleteById(id);
        return StudentResponse.builder().status("Success").studentId(id).message("Deleted").build();
    }
}
