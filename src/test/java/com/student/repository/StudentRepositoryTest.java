package com.student.repository;

import com.student.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testSaveStudent() {
        Student student = new Student(null, "John Doe", "9876543210");
        Student savedStudent = studentRepository.save(student);

        assertNotNull(savedStudent.getId());
        assertEquals("John Doe", savedStudent.getName());
    }

    @Test
    void testFindAllStudents() {
        Student student1 = new Student(null, "John Doe", "9876543210");
        Student student2 = new Student(null, "Jane Doe", "8765432109");

        studentRepository.save(student1);
        studentRepository.save(student2);

        List<Student> students = studentRepository.findAll();
        assertEquals(2, students.size());
    }
}
