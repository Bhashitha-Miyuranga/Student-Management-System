package com.example.student.Service;

import com.example.student.dto.StudentDTO;
import com.example.student.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void getAllStudent() {
        this.studentService.getAllStudent();
    }


    @Test
    void addStudent() {
        StudentDTO student = new StudentDTO();
        student.setFirst_Name("kamal");
        student.setLast_Name("kooora");
        student.setDistrict("mathara");
        studentService.addStudent(student);



    }

    @Test
    void getStudentByID() {
        this.studentService.getStudentByID(13);
    }


    @Test
    void getStudentByDistrict() {
        this.studentService.getStudentByDistrict("kurunegala");
    }
}