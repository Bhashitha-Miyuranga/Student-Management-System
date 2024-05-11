package com.example.student.dto;

import com.example.student.model.Department;
import com.example.student.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDTO {

    private Integer departmentID;

    private String departmentName;

    private String status;

    private List<StudentDTO> students;

    public DepartmentDTO(){
    }

    public DepartmentDTO(Department department){
        this.setDepartmentID(department.getDepartmentID());
        this.setDepartmentName(department.getDepartmentName());
        this.setStatus(department.getStatus());

        for (Student student : department.getStudents()){
            StudentDTO studentDTO = new StudentDTO(student);
            this.getStudents().add(studentDTO);
        }
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<StudentDTO> getStudents() {
        if(students == null){
            this.students = new ArrayList<>();
        }
        return students;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }
}
