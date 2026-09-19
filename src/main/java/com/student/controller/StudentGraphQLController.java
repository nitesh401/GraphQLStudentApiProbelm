package com.student.controller;

import com.student.dto.StudentPage;
import com.student.dto.StudentResponse;
import com.student.entity.Student;
import com.student.service.StudentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class StudentGraphQLController {
    private final StudentService studentService;

    public StudentGraphQLController(StudentService studentService) {
        this.studentService = studentService;
    }

    @QueryMapping
    public StudentPage getStudents(@Argument int page, @Argument int size, @Argument String nameFilter) {
        return studentService.getStudents(page, size, nameFilter);
    }

    @MutationMapping
    public StudentResponse addStudent(@Argument(name = "input") com.student.dto.StudentInput input) {
        Student student = Student.builder()
                .name(input.getName())
                .contact(input.getContact())
                .build();
        return studentService.addStudent(student);
    }

    @MutationMapping
    public StudentResponse updateStudent(@Argument Long id, @Argument(name = "input") com.student.dto.StudentInput input) {
        Student student = Student.builder()
                .id(id)
                .name(input.getName())
                .contact(input.getContact())
                .build();
        return studentService.updateStudent(id, student);
    }

    @MutationMapping
    public StudentResponse deleteStudent(@Argument Long id) {
        return studentService.deleteStudent(id);
    }
}
