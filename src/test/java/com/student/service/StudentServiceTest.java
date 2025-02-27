package com.student.service;

import com.student.dto.StudentResponse;
import com.student.entity.Student;
import com.student.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllStudents() {
        List<Student> students = Arrays.asList(
                new Student(1L, "John Doe", "9876543210"),
                new Student(2L, "Jane Doe", "8765432109")
        );

        when(studentRepository.findAll()).thenReturn(students);

        List<Student> result = studentService.getAllStudents();

        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    void testAddStudent() {
        Student student = new Student(null, "John Doe", "9876543210");
        Student savedStudent = new Student(1L, "John Doe", "9876543210");

        when(studentRepository.save(any(Student.class))).thenReturn(savedStudent);

        StudentResponse response = studentService.addStudent(student);

        assertEquals("Success", response.getStatus());
        assertEquals(1L, response.getStudentId());
    }
}
