package com.example.student.model;

import jakarta.persistence.*;


import java.util.Set;

@Entity
@Table(name = "t_department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTMENT_ID",nullable = false, updatable = false)
    private Integer departmentID;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    @Column(name = "STATUS")
    private String status;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL},orphanRemoval = true,mappedBy = "department")
    private Set<Student> students;

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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
