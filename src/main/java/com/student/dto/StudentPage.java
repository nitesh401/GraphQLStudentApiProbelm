package com.student.dto;

import com.student.entity.Student;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentPage {
    private List<Student> students;
    private int totalCount;
}
