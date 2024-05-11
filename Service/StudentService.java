package com.example.student.Service;

import com.example.student.dao.DepartmentDao;
import com.example.student.dao.StudentDao;
import com.example.student.dto.StudentDTO;
import com.example.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private DepartmentDao departmentDao;

    public List<StudentDTO> getAllStudent(){
       List<Student> students =  this.studentDao.findAll();

       List<StudentDTO> studentDTOs = new ArrayList<>();

       for (Student student : students){
           StudentDTO studentDTO = new StudentDTO(student);

           studentDTOs.add(studentDTO);
       }

       return studentDTOs;
    }

    public StudentDTO addStudent(StudentDTO studentDTO){
       Student student = null;

       if(studentDTO.getStudentID() != null){
           student = this.studentDao.getById(studentDTO.getStudentID());
        }else{
           student = new Student();
        }

       student.setFirst_Name(studentDTO.getFirst_Name());
       student.setLast_Name(studentDTO.getLast_Name());
       student.setDistrict(studentDTO.getDistrict());
       student.setDepartment(this.departmentDao.getById(studentDTO.getDepartmentID()));

       student = this.studentDao.saveAndFlush(student);

       return new StudentDTO(student);
    }

    public StudentDTO getStudentByID(Integer studentID){
        Student student = this.studentDao.findByStudentID(studentID);
        return new StudentDTO(student);
    }

    public List<StudentDTO> getStudentByDistrict(String district){
       List<Student> students = this.studentDao.findAllByDistrict(district);

        List<StudentDTO> studentDTOs = new ArrayList<>();

        for (Student student : students){
            StudentDTO studentDTO = new StudentDTO(student);

            studentDTOs.add(studentDTO);
        }

        return studentDTOs;
    }

    public Student updateStudent(Student student){
        Student existingStudent = this.studentDao.saveAndFlush(student);
        return existingStudent;
    }

    public void deleteStudent(Integer studentID) {
        // Find the student by ID
        Student student = studentDao.findById(studentID).orElse(null);

        if (student != null) {
            // Delete the student from the database
            studentDao.delete(student);
        } else {
            // Handle the case where the student with the given ID is not found.
            // You can throw an exception or handle it based on your application's requirements.
        }
    }
}
