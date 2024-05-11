package com.example.student.controller;

import com.example.student.Service.StudentService;
import com.example.student.dto.StudentDTO;
import com.example.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class Controller {

    @Autowired
    private StudentService studentService;


    @RequestMapping(value = "/getAllStudent",method = RequestMethod.GET)
    public ResponseEntity<List<StudentDTO>> getAllStudent(){
        List<StudentDTO> students = this.studentService.getAllStudent();


        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @RequestMapping(value = "/addStudent",method = RequestMethod.POST)
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO){
       StudentDTO newStudent = this.studentService.addStudent(studentDTO);

       return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getStudentByID/{studentID}",method = RequestMethod.GET)
    public ResponseEntity<StudentDTO> getStudentByID(@PathVariable Integer studentID){
        StudentDTO student = this.studentService.getStudentByID(studentID);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @RequestMapping(value = "/getStudentByDistrict/{district}")
    public ResponseEntity<List<StudentDTO>> getStudentByDistrict(@PathVariable String district){
        List<StudentDTO> students = this.studentService.getStudentByDistrict(district);

        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @RequestMapping(value = "/updateStudent",method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student existingStudent = this.studentService.updateStudent(student);

        return new ResponseEntity<>(existingStudent,HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{studentID}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer studentID) {
        studentService.deleteStudent(studentID);
        return new ResponseEntity<>("Student with ID " + studentID + " has been deleted", HttpStatus.OK);
    }
}
