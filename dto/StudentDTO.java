package com.example.student.dto;

import com.example.student.model.Student;

public class StudentDTO {

    private Integer studentID;

    private String first_Name;

    private String last_Name;

    private String district;

    private Integer departmentID;

    private String departmentName;

    public StudentDTO(){
    }

    public StudentDTO(Student student){
        this.studentID = student.getStudentID();
        this.first_Name = student.getFirst_Name();
        this.last_Name = student.getLast_Name();
        this.district = student.getDistrict();

        if (student.getDepartment() != null) {
            this.departmentID = student.getDepartment().getDepartmentID();
            this.departmentName = student.getDepartment().getDepartmentName();
        }
    }


    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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
}
