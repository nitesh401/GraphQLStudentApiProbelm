package com.student.service;

import com.student.dto.StudentResponse;
import com.student.entity.Student;
import com.student.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentResponse addStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        return new StudentResponse("Success", savedStudent.getId());
    }
}
