package com.student.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentInput {
    private String name;
    private String contact;
}
