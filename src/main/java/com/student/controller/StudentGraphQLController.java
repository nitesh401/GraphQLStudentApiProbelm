package com.student.controller;

import com.student.dto.StudentResponse;
import com.student.entity.Student;
import com.student.service.StudentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class StudentGraphQLController {
    private final StudentService studentService;

    public StudentGraphQLController(StudentService studentService) {
        this.studentService = studentService;
    }

    @QueryMapping
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @MutationMapping
    public StudentResponse addStudent(@Argument String name, @Argument String contact) {
        Student student = Student.builder()
                .name(name)
                .contact(contact)
                .build();
        return studentService.addStudent(student);
    }
}
