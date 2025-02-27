package com.student.controller;

import com.student.dto.StudentResponse;
import com.student.entity.Student;
import com.student.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentGraphQLControllerTest {

    @Mock
    private StudentService studentService;
    @InjectMocks
    private StudentGraphQLController studentGraphQLController;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetStudents() {
        List<Student> students = Arrays.asList(
                new Student(1L, "John Doe", "9876543210"),
                new Student(2L, "Jane Doe", "8765432109")
        );
        when(studentService.getAllStudents()).thenReturn(students);
        List<Student> result = studentGraphQLController.getStudents();
        assertEquals(2, result.size());
        assertEquals("Jane Doe", result.get(1).getName());
    }

    @Test
    void testAddStudent() {
        StudentResponse response = new StudentResponse("Success", 1L);
        when(studentService.addStudent(any(Student.class))).thenReturn(response);
        StudentResponse result = studentGraphQLController.addStudent("John Doe", "9876543210");
        assertEquals("Success", result.getStatus());
        assertEquals(1L, result.getStudentId());
    }
}
